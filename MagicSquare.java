import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Brolen Gumb
 * @version 1.0
 * 
 */

public class MagicSquare implements MagicSquareInterface {

    Random rand = new Random();
    private int[][] matrix;

    public MagicSquare(String filename) throws FileNotFoundException {
        // Constructor takes filename & attempts to read that file
        readMatrix(filename);

        File file = new File(filename);
        Scanner scnr = new Scanner(file);
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            System.out.println(line);
        }
        scnr.close();
    }

    private int[][] readMatrix(String filename) throws FileNotFoundException {
        // Reads matrix from file & returns as 2D array of integers
        File file = new File(filename);
        Scanner scnr = new Scanner(file);
        int dimension = scnr.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scnr.nextInt();
            }
        }
        scnr.close();
        return matrix;

    }

    // Constructor takes filename & dimension integer
    public MagicSquare(String filename, int dimension) throws IOException {

        writeMatrix(getMatrix(), filename);

        int n = dimension * dimension;
        int[][] matrix = new int[dimension][dimension];
        int row = n - 1;
        int col = n / 2;
        int oldRow = row;
        int oldCol = col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;

            }
        }

        if (matrix[row % dimension][col % dimension] != 0) {
            row = oldRow;
            col = oldCol;
            row--;
        }
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        PrintWriter outFile = new PrintWriter(writer);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                outFile.print(matrix[i][j] + " ");
            }
            outFile.println();
        }
        outFile.close();
    }

    /*
     * Evaluates matrix & returns a boolean verdict
     * of whether the matrix is a magic square.
     * A magic square is valid if the matrix consists of incrementing
     * integrals starting at '1' & ending at the product of the
     * given integer^2 without repeating any integers.
     * Expl:
     * n = 3, 3^2 = 9
     * 4 9 2
     * 3 5 7
     * 8 1 6
     */

    public boolean isMagicSquare() {
        if (getMatrix() != null) {
            return true;
        } else {
            return false;
        }
    }

    // Returns a copy of the matrix as a 2D array of integers
    public int[][] getMatrix() {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        return newMatrix;
    }

    /**
     * Returns a string formatted as in these examples:
     * The matrix
     * 4 9 2
     * 3 5 7
     * 8 1 6
     * is a magic square.
     * or
     * The matrix
     * 5 3 7
     * 9 4 2
     * 1 6 5
     * is not a magic square.
     */

    public String toString() {
        String result = "The matrix\n";
        int[][] matrix = getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }

        if (isMagicSquare()) {
            result += "is a magic square.";
        } else {
            result += "is not a magic square.";
        }
        return result;
    }
}