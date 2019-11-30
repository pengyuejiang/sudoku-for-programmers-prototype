import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Solver {

    /**
     * Import a Sudoku puzzle from file.
     * @param fileName the file that contains the puzzle
     * @return a Sudoku grid
     * @throws FileNotFoundException throws this exception if the file is not found
     */
    public static Grid importPuzzleFromFile(String fileName) throws FileNotFoundException {
        // Change for base 16
        int[][] array = new int[9][9];
        Scanner input = new Scanner(new File(fileName));
        for (int i = 0; input.hasNext(); i++) {
            String[] temp = input.nextLine().split(",");
            // Change for base 16
            int[] data = new int[9];
            for (int j = 0; j < temp.length; j++) {
                // Change for base 16
                data[j] = Integer.parseInt(temp[j].trim());
            }
            array[i] = data;
        }
        input.close();
        return new Grid(array);
    }

    /** Update the possibilities remaining for each cell. */
    public static void updatePossibilities(Grid grid) {
        for (int i = 0; i < grid.DIMENSION; i++) {
            for (int j= 0; j < grid.DIMENSION; j++) {
                Grid.Cell current = grid.cells[i][j];
                // If the cell is already filled, no more possibilities
                if (current.confirmed) {
                    continue;
                }
                // Initialize possibilities
                current.possibilities = new ArrayList<>();
                // Change for base 16
                for (int k = 1; k <= grid.DIMENSION; k++) {
                    if (possibleToAdd(grid, current, k)) current.possibilities.add(k);
                }
            }
        }
    }

    /**
     * Check against three conditions to see if
     * it is possible to consider a number as possibility.
     * @param grid the grid to add
     * @param cell the cell to add possibilities
     * @param number the potential number to add
     * @return whether it is possible to add the number to the cell
     */
    private static boolean possibleToAdd(Grid grid, Grid.Cell cell, int number) {
        if (violatesRowRule(grid, cell, number)
                || violatesColumnRule(grid, cell, number)
                || violatesBlockRule(grid, cell, number)) {
            return false;
        }
        return true;
    }

    /**
     * Check against row repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the row repetition rule
     */
    private static boolean violatesRowRule(Grid grid, Grid.Cell cell, int number) {
        // Check for repetition in the same row
        for (int i = 0; i < grid.DIMENSION; i++) {
            if (number == grid.cells[cell.row][i].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Check against column repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the column repetition rule
     */
    private static boolean violatesColumnRule(Grid grid, Grid.Cell cell, int number) {
        // Check for repetition in the same column
        for (int i = 0; i < grid.DIMENSION; i++) {
            if (number == grid.cells[i][cell.column].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Check against block repetition rule.
     * @param grid the grid to check
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the block repetition rule
     */
    private static boolean violatesBlockRule(Grid grid, Grid.Cell cell, int number) {
        // Check for repetition in the same block
        // Iterate through the rows in the block
        for (int i = cell.block / grid.BASE_INDEX * grid.BASE_INDEX; i < cell.block / grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; i++) {
            // Iterate through the columns in the block
            for (int j = cell.block % grid.BASE_INDEX * grid.BASE_INDEX; j < cell.block % grid.BASE_INDEX * grid.BASE_INDEX + grid.BASE_INDEX; j++) {
                // If repetition is found
                if (number == grid.cells[i][j].value) {
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
    public static void confirmNumbers(Grid grid) {
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
                    System.out.printf("Naked single of %d at %d, %d, block %d\n", cell.value, cell.row, cell.column, cell.block);
                    // @DEBUG END

                    // CRITICAL! Every time you update a cell, remove possibilities in cells
                    // in the same row, column, and block! If not this will cause a problem for
                    // hidden single checks!
                    removePossibilityInRow(grid, cell.row, cell.value);
                    removePossibilityInColumn(grid, cell.column, cell.value);
                    removePossibilityInBlock(grid, cell.block, cell.value);
                } else if (cell.possibilities.size() == 0) {
                    System.out.println(i + ", " + j + "has no solution.");
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
                            // @DEBUG
                            System.out.println();
                            System.out.printf("Hidden single of %d in %d, %d\n", possibility, cell.row, cell.column);
                            System.out.println("Hidden in row: " + Solver.hiddenSingleInRow(grid, cell, possibility));
                            System.out.println("Hidden in column: " + Solver.hiddenSingleInColumn(grid, cell, possibility));
                            System.out.println("Hidden in block: " + Solver.hiddenSingleInBlock(grid, cell, possibility));
                            // @DEBUG END
                            cell.value = possibility;
                            cell.confirmed = true;
                            cell.possibilities = null;
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

    private static void removePossibilityInRow(Grid grid, int row, int value) {
        for (int i = 0; i < grid.DIMENSION; i++) {
            ArrayList<Integer> possibilities = grid.cells[row][i].possibilities;
            if (possibilities != null && possibilities.indexOf(value) != -1) {
                // This is to prevent the list from moving with index
                possibilities.remove(possibilities.indexOf(value));
                // @DEBUG
                System.out.printf("Removing Row Possibility of %d in cell %d, %d\n", value, row, i);
                System.out.println("Original: " + grid.cells[row][i].possibilities);
                System.out.println("Removed " + value + ", now " + possibilities);
                System.out.println();
                // @DEBUG END
            }
        }
    }

    private static void removePossibilityInColumn(Grid grid, int column, int value) {
        for (int i = 0; i < grid.DIMENSION; i++) {
            ArrayList<Integer> possibilities = grid.cells[i][column].possibilities;
            if (possibilities != null && possibilities.indexOf(value) != -1) {
                // This is to prevent the list from moving with index
                possibilities.remove(possibilities.indexOf(value));
                // @DEBUG
                System.out.printf("Removing Column Possibility of %d in cell %d, %d\n", value, i, column);
                System.out.println("Original: " + grid.cells[i][column].possibilities);
                System.out.println("Removed " + value + ", now " + possibilities);
                System.out.println();
                // @DEBUG END
            }
        }
    }

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
                    System.out.printf("Removing Block Possibility of %d in cell %d, %d\n", value, i, j);
                    System.out.println("Original: " + grid.cells[i][j].possibilities);
                    System.out.println("Removed " + value + ", now " + possibilities);
                    System.out.println();
                    // @DEBUG END
                }
            }
        }
    }

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
            Solver.confirmNumbers(grid);
            System.out.println();
            // Print it again
            grid.printGrid();
        }
    }

    public static void main(String[] args) {
        try {
            Grid grid;
            grid = importPuzzleFromFile("sudoku.txt");
            grid.printGrid();
            Solver.solve(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } 

}