import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Solver {

    /**
     * Import a Sudoku puzzle from file.
     * @param fileName the file that contains the puzzle
     * @return a Sudoku grid
     * @throws FileNotFoundException throws this exception if the file is not found
     */
    public static Grid importPuzzleFromFile(String fileName) throws FileNotFoundException {
        int[][] array = new int[9][9];
        Scanner input = new Scanner(new File(fileName));
        for (int i = 0; input.hasNext(); i++) {
            String[] temp = input.nextLine().split(",");
            int[] data = new int[9];
            for (int j = 0; j < temp.length; j++) {
                data[j] = Integer.parseInt(temp[j].trim());
            }
            array[i] = data;
        }
        Grid grid = new Grid(array);
        input.close();
        return grid;
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
                // If it's already confirmed, do nothing
                if (grid.cells[i][j].confirmed) {
                    continue;
                }
                // Condition for confirmation
                if (grid.cells[i][j].possibilities.size() == 1) {
                    grid.cells[i][j].value = grid.cells[i][j].possibilities.get(0);
                    grid.cells[i][j].confirmed = true;
                    grid.cells[i][j].possibilities = null;
                } else if (grid.cells[i][j].possibilities.size() == 0) {
                    System.out.println(i + ", " + j);
                    // If nothing is possible, the puzzle is wrong itself
                    System.out.println("Your puzzle is wrong.");
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Grid grid;
            grid = importPuzzleFromFile("sudoku.txt");
            grid.printGrid();
            // @TEST
            while (!grid.isSolved()) {
                // Initialize it at the beginning
                Solver.updatePossibilities(grid);
                // Solve it for one step
                Solver.confirmNumbers(grid);
                System.out.println();
                // Print it again
                grid.printGrid();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } 

}