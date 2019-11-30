import java.util.ArrayList;

/** A class to represent the Sudoku grid. */
public class Grid {
    
    /** A class to encapsulate one Sudoku cell. */
    public class Cell {

        /** Number value of the cell. */
        public int value;
        
        /** Whether the cell has been confirmed. Cells came with the problem are confirmed. */
        public boolean confirmed;

        /** The possibilities that an empty cell possesses. */
        public ArrayList<Integer> possibilities;

        /** Marks the row of the cell, starting with 0. */
        public int row;

        /** Marks the column of the cell, starting with 0. */
        public int column;

        /** Marks the block of the cell, starting with 0, left to right, top to bottom. */
        public int block;

        /**
         * Instantiate a cell with the given properties.
         * @param value value of the cell
         * @param row the cell's row
         * @param column the cell's column
         */
        public Cell(int value, int row, int column) {
            this.value = value;
            this.confirmed = value != -1;
            this.row = row;
            this.column = column;
            this.block = row / BASE_INDEX * BASE_INDEX + column / BASE_INDEX;
        }

    }

    /** Cells in a Sudoku grid. */
    // This configuration is for 16x16 Sudoku specifically.
    public Cell[][] cells = new Cell[16][16];

    /** Base index of the game. */
    // This configuration is for 16x16 Sudoku specifically.
    public final int BASE_INDEX = 4;

    /** Dimension of the game. */
    public final int DIMENSION = BASE_INDEX * BASE_INDEX;

    /**
     * A constructor for cells with input array.
     * @param array input array representing the Sudoku grid
     */
    public Grid(int[][] array) {
        for (int i = 0; i < this.DIMENSION; i++) {
            for (int j = 0; j < this.DIMENSION; j++) {
                cells[i][j] = new Cell(array[i][j], i, j);
            }
        }
    }

    /** A method to view the grid. */
    public void printGrid() {
        for (int i = 0; i < this.DIMENSION; i++) {
            System.out.print("[");
            for (int j = 0; j < this.DIMENSION; j++) {
                if (cells[i][j].value == -1) {
                    System.out.print(".");
                } else {
                    System.out.print(Integer.toHexString(cells[i][j].value).toUpperCase());
                }
                System.out.print(", ");
            }
            System.out.println("\b\b]");
        }
    }

    /**
     * Check whether the puzzle is solved (means no cell is empty).
     * @return whether the puzzle is solved or not
     */
    public boolean isSolved() {
        for (int i = 0; i < this.DIMENSION; i++) {
            for (int j = 0; j < this.DIMENSION; j++) {
                if (this.cells[i][j].value == -1) {
                    return false;
                }
            }
        }
        return true;
    }

}