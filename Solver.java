import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Solver {

    /**
     * Import a Sudoku puzzle from file.
     * @param fileName the file that contains the puzzle
     * @return a Sudoku grid
     * @throws FileNotFoundException throws this exception if the puzzle file does not exist
     */
    public static Grid importPuzzleFromFile(String fileName) throws FileNotFoundException {
        // Specifically set for 16x16 Sudoku
        int[][] array = new int[16][16];
        Scanner input = new Scanner(new File(fileName));
        // Read line by line
        for (int i = 0; input.hasNext(); i++) {
            // Split a line to convert to an array
            String[] raw = input.nextLine().split(",");
            // Specifically set for 16x16 Sudoku
            int[] processed = new int[16];
            for (int j = 0; j < raw.length; j++) {
                // "." can be other things as well, such as "*" or even "$"
                if (raw[j].trim().equals(".")) {
                    processed[j] = -1;
                } else {
                    processed[j] = Integer.parseInt(raw[j].trim(), 16);
                }
                
            }
            array[i] = processed;
        }
        input.close();
        return new Grid(array);
    }

    /**
     * Update the possibilities remaining for each cell.
     * @param grid the puzzle grid to update for
     */
    public static void updatePossibilities(Grid grid) {
        // A conventional loop to go through cells
        for (int i = 0; i < grid.DIMENSION; i++) {
            for (int j = 0; j < grid.DIMENSION; j++) {
                Grid.Cell current = grid.cells[i][j];
                // If the cell is already confirmed, no more possibilities
                if (current.confirmed) {
                    continue;
                }
                // Initialize possibilities as an array list
                current.possibilities = new ArrayList<>();
                // Going through the possibilities to see if they are possible at all
                // IMPORTANT! Traditional 9x9 Sudoku starts from 1, but ours starts from 0
                for (int possibility = 0; possibility < grid.DIMENSION; possibility++) {
                    if (possibleToAdd(grid, current, possibility)) {
                        current.possibilities.add(possibility);
                    }
                }
            }
        }
    }

    /**
     * Check against three conditions to see if
     * it is possible to consider a number as possibility.
     * @param grid the grid to add
     * @param cell the cell to add possibilities
     * @param possibility the potential number to add
     * @return whether it is possible to add a possibility to the cell
     */
    private static boolean possibleToAdd(Grid grid, Grid.Cell cell, int possibility) {
        // If a possibility violates any one of the three checks
        if (violatesRowRule(grid, cell, possibility)
                || violatesColumnRule(grid, cell, possibility)
                || violatesBlockRule(grid, cell, possibility)) {
            // They are no longer eligible
            return false;
        }
        // If passed all three test, congratulations!
        return true;
    }

    /**
     * Auxiliary method that check against row repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param possibility the number to check
     * @return whether this number violates the row repetition rule
     */
    private static boolean violatesRowRule(Grid grid, Grid.Cell cell, int possibility) {
        // Check for repetition in the same row
        for (int i = 0; i < grid.DIMENSION; i++) {
            if (possibility == grid.cells[cell.row][i].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Auxiliary method that check against column repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param possibility the number to check
     * @return whether this number violates the column repetition rule
     */
    private static boolean violatesColumnRule(Grid grid, Grid.Cell cell, int possibility) {
        // Check for repetition in the same column
        for (int i = 0; i < grid.DIMENSION; i++) {
            if (possibility == grid.cells[i][cell.column].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Auxiliary method that check against block repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param possibility the number to check
     * @return whether this number violates the block repetition rule
     */
    private static boolean violatesBlockRule(Grid grid, Grid.Cell cell, int possibility) {
        // Check for repetition in the same block
        // Iterate through the rows in the block
        for (int i = cell.block / grid.BASE_INDEX * grid.BASE_INDEX;
                i < cell.block / grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; i++) {
            // Iterate through the columns in the block
            for (int j = cell.block % grid.BASE_INDEX * grid.BASE_INDEX;
                    j < cell.block % grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; j++) {
                // If repetition is found
                if (possibility == grid.cells[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Put a given number into place.
     * @param grid the grid to solve
     */
    public static void step(Grid grid) {
        // For each cell
        for (int i = 0; i < grid.DIMENSION; i++) {
            for (int j = 0; j < grid.DIMENSION; j++) {
                // We're gonna use this a lot, so better store it first
                Grid.Cell cell = grid.cells[i][j];
                // If it's already confirmed, do nothing
                if (cell.confirmed) {
                    continue;
                }
                // Condition for confirmation
                if (cell.possibilities.size() == 1) {
                    // If the cell only has one possibility (Naked Single Theorem)
                    cell.value = cell.possibilities.get(0);
                    cell.confirmed = true;
                    cell.possibilities = null;

                    // @DEBUG
                    System.out.printf("Naked single of %s at R%sC%sB%s (from 0)\n",
                            Integer.toHexString(cell.value),
                            Integer.toHexString(cell.row),
                            Integer.toHexString(cell.column),
                            Integer.toHexString(cell.block));
                    // @DEBUG END

                    // CRITICAL! Every time you update a cell, remove possibilities in cells
                    // in the same row, column, and block! If not this will cause a problem for
                    // hidden single checks!
                    removePossibilityInRow(grid, cell.row, cell.value);
                    removePossibilityInColumn(grid, cell.column, cell.value);
                    removePossibilityInBlock(grid, cell.block, cell.value);
                } else if (cell.possibilities.size() == 0) {
                    System.out.printf("Cell (%s, %s) has no solution.\n",
                            Integer.toHexString(i),
                            Integer.toHexString(j));
                    // If nothing is possible, the puzzle is wrong itself
                    System.out.println("Your puzzle is wrong.");
                    grid.printGrid();
                    System.exit(1);
                } else {
                    // This is the case where a cell has multiple possibilities
                    // Check for each possibility of a cell to see if Hidden Single Theorem
                    // can be applied
                    for (Integer possibility : cell.possibilities) {
                        if ((Solver.hiddenSingleInRow(grid, cell, possibility)
                                || Solver.hiddenSingleInColumn(grid, cell, possibility)
                                || Solver.hiddenSingleInBlock(grid, cell, possibility))
                                && possibleToAdd(grid, cell, possibility)) {
                            cell.value = possibility;
                            cell.confirmed = true;
                            cell.possibilities = null;
                            // @DEBUG
                            System.out.printf("Hidden single of %s at R%sC%sB%s (from 0)\n",
                                    Integer.toHexString(cell.value),
                                    Integer.toHexString(cell.row),
                                    Integer.toHexString(cell.column),
                                    Integer.toHexString(cell.block));
                            // @DEBUG END
                            // CRITICAL! Every time you update a cell, remove possibilities in
                            // cells in the same row, column, and block! If not this will cause
                            // problems!
                            removePossibilityInRow(grid, cell.row, cell.value);
                            removePossibilityInColumn(grid, cell.column, cell.value);
                            removePossibilityInBlock(grid, cell.block, cell.value);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Remove a given possibility in a specified row.
     * @param grid the puzzle grid
     * @param row the row to remove possibility for
     * @param value the possibility to remove
     */
    private static void removePossibilityInRow(Grid grid, int row, int value) {
        for (int i = 0; i < grid.DIMENSION; i++) {
            ArrayList<Integer> possibilities = grid.cells[row][i].possibilities;
            // Remove the possibility only if the cell is unconfirmed and has the value
            if (possibilities != null && possibilities.indexOf(value) != -1) {
                // This is to prevent the list from moving with index
                possibilities.remove(possibilities.indexOf(value));
                // @DEBUG
                System.out.printf("Removing Row Possibility of %s in cell (%s, %s)\n",
                        Integer.toHexString(value),
                        Integer.toHexString(row),
                        Integer.toHexString(i));
                // @DEBUG END
            }
        }
    }

    /**
     * Remove a given possibility in a specified column.
     * @param grid the puzzle grid
     * @param column the column to remove possibility for
     * @param value the possibility to remove
     */
    private static void removePossibilityInColumn(Grid grid, int column, int value) {
        for (int i = 0; i < grid.DIMENSION; i++) {
            ArrayList<Integer> possibilities = grid.cells[i][column].possibilities;
            if (possibilities != null && possibilities.indexOf(value) != -1) {
                // This is to prevent the list from moving with index
                possibilities.remove(possibilities.indexOf(value));
                // @DEBUG
                System.out.printf("Removing Column Possibility of %s in cell (%s, %s)\n",
                        Integer.toHexString(value),
                        Integer.toHexString(i),
                        Integer.toHexString(column));
                // @DEBUG END
            }
        }
    }

    /**
     * Remove a given possibility in a specified block.
     * @param grid the puzzle grid
     * @param block the block to remove possibility for
     * @param value the possibility to remove
     */
    private static void removePossibilityInBlock(Grid grid, int block, int value) {
        for (int i = block / grid.BASE_INDEX * grid.BASE_INDEX;
                i < block / grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; i++) {
            for (int j = block % grid.BASE_INDEX * grid.BASE_INDEX;
                j < block % grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; j++) {
                    ArrayList<Integer> possibilities = grid.cells[i][j].possibilities;
                if (possibilities != null && possibilities.indexOf(value) != -1) {
                    // This is to prevent the list from moving with index
                    possibilities.remove(possibilities.indexOf(value));
                    // @DEBUG
                    System.out.printf("Removing Block Possibility of %s in cell (%s, %s)\n",
                            Integer.toHexString(value),
                            Integer.toHexString(i),
                            Integer.toHexString(j));
                    // @DEBUG END
                }
            }
        }
    }

    /**
     * An auxiliary method to see if a possibility is a hidden single.
     * @param grid the puzzle grid
     * @param cell the cell that contains the possibility
     * @param possibility a potential number
     * @return
     */
    public static boolean hiddenSingleInRow(Grid grid, Grid.Cell cell, int possibility) {
        int count = 0;
        for (int i = 0; i < grid.DIMENSION; i++) {
            Grid.Cell toCheck = grid.cells[cell.row][i];
            // If the cell is not confirmed and contains the possibility, add one to count
            if (!toCheck.confirmed && toCheck.possibilities.contains(possibility)) {
                count++;
            }
        }
        // If it is the only possibility in row, return true
        return count == 1;
    }
    
    /**
     * An auxiliary method to see if a possibility is a hidden single.
     * @param grid the puzzle grid
     * @param cell the cell that contains the possibility
     * @param possibility a potential number
     * @return
     */
    public static boolean hiddenSingleInColumn(Grid grid, Grid.Cell cell, int possibility) {
        int count = 0;
        for (int i = 0; i < grid.DIMENSION; i++) {
            Grid.Cell toCheck = grid.cells[i][cell.column];
            // If the cell is not confirmed and contains the possibility, add one to count
            if (!toCheck.confirmed && toCheck.possibilities.contains(possibility)) {
                count++;
            }
        }
        // If it is the only possibility in column, return true
        return count == 1;
    }

    /**
     * An auxiliary method to see if a possibility is a hidden single.
     * @param grid the puzzle grid
     * @param cell the cell that contains the possibility
     * @param possibility a potential number
     * @return
     */
    public static boolean hiddenSingleInBlock(Grid grid, Grid.Cell cell, int possibility) {
        int count = 0;
        // Iterate through the rows in the block
        for (int i = cell.block / grid.BASE_INDEX * grid.BASE_INDEX;
                i < cell.block / grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; i++) {
            // Iterate through the columns in the block
            for (int j = cell.block % grid.BASE_INDEX * grid.BASE_INDEX;
                    j < cell.block % grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; j++) {
                Grid.Cell toCheck = grid.cells[i][j];
                // If the cell is not confirmed and contains the possibility, add one to count
                if (!toCheck.confirmed && toCheck.possibilities.contains(possibility)) {
                    count++;
                }
            }
        }
        // If it is the only possibility in column, return true
        return count == 1;
    }

    /**
     * A method to solve the puzzle by repeating steps
     * @param grid the puzzle grid to solve
     */
    public static void solve(Grid grid) {
        while (!grid.isSolved()) {
            // Initialize it at the beginning
            Solver.updatePossibilities(grid);
            // Solve it for one step
            Solver.step(grid);
            // Print it again
            grid.printGrid();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            Grid grid;
            grid = importPuzzleFromFile("sudoku.txt");
            grid.printGrid();
            Solver.solve(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Run Time: " + (end - start) + "ms");
    } 

}