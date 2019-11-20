import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TestSudoku {

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

    public static void main(String[] args) {
        try {
            Grid grid;
            grid = importPuzzleFromFile("sudoku.txt");
            grid.printGrid();
            // @TEST
            while (!grid.isSolved()) {
                // Initialize it at the beginning
                grid.updatePossibilities();
                // Solve it for one step
                grid.confirmNumbers();
                System.out.println();
                // Print it again
                grid.printGrid();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}