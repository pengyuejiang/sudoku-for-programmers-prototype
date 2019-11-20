import java.util.ArrayList;

/** A class to represent the Sudoku grid. */
public class Grid {
    
    /** A class to encapsulate one Sudoku cell. */
    private class Cell {
        /** Number value of the cell. */
        private int value;
        /** Whether the cell has been confirmed. Cells came with the problem are confirmed. */
        private boolean confirmed;
        /** The possibilities that an empty cell possesses. */
        private ArrayList<Integer> possibilities;
        /** Marks the row of the cell, starting with 0. */
        private int row;
        /** Marks the column of the cell, starting with 0. */
        private int column;
        /** Marks the block of the cell, starting with 0, left to right, top to bottom. */
        private int block;
        
        /**
         * Instantiate a cell with the given properties.
         * @param value value of the cell
         * @param row the cell's row
         * @param column the cell's column
         */
        public Cell(int value, int row, int column) {
            this.value = value;
            if (value != 0) {
                this.confirmed = true;
            }
            this.row = row;
            this.column = column;
            this.block = row / baseIndex * baseIndex + column / baseIndex;
        }
    }

    /** Cells in a Sudoku grid. */
    private Cell[][] cells = new Cell[9][9];

    /** Base of the game. */
    private int baseIndex = 3;

    /** Dimension of the game. */
    private int dimension = baseIndex * baseIndex;

    /**
     * A constructor for cells with input array.
     * @param array input array representing the Sudoku grid
     */
    public Grid(int[][] array) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells[i][j] = new Cell(array[i][j], i, j);
            }
        }
    }

    /** Update the possibilities remaining for each cell. */
    public void updatePossibilities() {
        for (int i = 0; i < dimension; i++) {
            for (int j= 0; j < dimension; j++) {
                Cell current = cells[i][j];
                // If the cell is already filled, no more possibilities
                if (current.confirmed) {
                    continue;
                }
                // Initialize possibilities
                current.possibilities = new ArrayList<>();
                for (int k = 1; k <= 9; k++) {
                    if (possibleToAdd(current, k)) current.possibilities.add(k);
                }
            }
        }
    }

    /**
     * Check against three conditions to see if
     * it is possible to consider a number as possibility.
     * @param cell the cell to add possibilities
     * @param number the potential number to add
     * @return whether it is possible to add the number to the cell
     */
    private boolean possibleToAdd(Cell cell, int number) {
        if (violatesRowRule(cell, number)
                || violatesColumnRule(cell, number)
                || violatesBlockRule(cell, number)) {
            return false;
        }
        return true;
    }


    /**
     * Check against row repetition rule.
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the row repetition rule
     */
    private boolean violatesRowRule(Cell cell, int number) {
        // Check for repetition in the same row
        for (int i = 0; i < dimension; i++) {
            if (number == cells[cell.row][i].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Check against column repetition rule.
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the column repetition rule
     */
    private boolean violatesColumnRule(Cell cell, int number) {
        // Check for repetition in the same column
        for (int i = 0; i < dimension; i++) {
            if (number == cells[i][cell.column].value) {
                return true;
            }
        }
        // If found no repetition, return false
        return false;
    }

    /**
     * Check against block repetition rule.
     * @param cell the cell to check
     * @param number the number to check
     * @return whether this number violates the block repetition rule
     */
    private boolean violatesBlockRule(Cell cell, int number) {
        // Check for repetition in the same block
        // Iterate through the rows in the block
        for (int i = cell.block / baseIndex * baseIndex; i < cell.block / baseIndex * baseIndex + baseIndex; i++) {
            // Iterate through the columns in the block
            for (int j = cell.block % baseIndex * baseIndex; j < cell.block % baseIndex * baseIndex + baseIndex; j++) {
                // If repetition is found
                if (number == cells[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    /** A method to view the grid. */
    public void printGrid() {
        for (int i = 0; i < dimension; i++) {
            System.out.print("[");
            for (int j = 0; j < dimension; j++) {
                System.out.print(cells[i][j].value + ", ");
            }
            System.out.println("\b\b]");
        }
    }

    /** Put a given number into place. */
    public void confirmNumbers() {
        // For each cell
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                // If it's already confirmed, do nothing
                if (cells[i][j].confirmed) {
                    continue;
                }
                // Condition for confirmation
                if (cells[i][j].possibilities.size() == 1) {
                    cells[i][j].value = cells[i][j].possibilities.get(0);
                    cells[i][j].confirmed = true;
                    cells[i][j].possibilities = null;
                } else if (cells[i][j].possibilities.size() == 0) {
                    System.out.println(i + ", " + j);
                    // If nothing is possible, the puzzle is wrong itself
                    System.out.println("Your puzzle is wrong.");
                    System.exit(1);
                }
            }
        }
    }

    public boolean isSolved() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (this.cells[i][j].value == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}