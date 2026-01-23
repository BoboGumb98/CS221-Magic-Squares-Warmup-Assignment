import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Brolen Gumb
 * @version 1.0
 * 
 */

public class MagicSquare implements MagicSquareInterface {

    private int[][] matrix;

    // Constructor takes filename & attempts to read that file
    public MagicSquare(String filename) throws FileNotFoundException {
        matrix = readMatrix(filename);
    }

    // Constructor takes filename & dimension integer
    public MagicSquare(String filename, int dimension) throws IOException {

        // From project handout
        // int n = dimension * dimension;
        matrix = new int[dimension][dimension];
        int row = dimension - 1;
        int col = dimension / 2;
        int oldRow, oldCol;

        for (int i = 1; i <= dimension * dimension; i++) {
            matrix[row][col] = i;
            oldRow = row;
            oldCol = col;
            row++;
            col++;
            if (row == dimension) {
                row = 0;
            }
            if (col == dimension) {
                col = 0;
            }
            if (matrix[row][col] != 0) {
                row = oldRow;
                col = oldCol;
                if (row <= 0) {
                
                    return;
                }
                row--;
            }
        }
        writeMatrix(matrix, filename);
    }

    private int[][] readMatrix(String filename) throws FileNotFoundException {
        // Reads matrix from file & returns as 2D array of integers
        File file = new File(filename);
        Scanner scnr = new Scanner(file);

        if (!scnr.hasNextInt()) {
            scnr.close();
            return null;
        }

        int dimension = scnr.nextInt();
        int[][] tempMatrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tempMatrix[i][j] = scnr.nextInt();
            }
        }
        scnr.close();
        return tempMatrix;
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        File file = new File(filename);
        PrintWriter outFile = new PrintWriter(file);
        outFile.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                outFile.print(matrix[i][j] + " ");
            }
            outFile.println();
        }
        outFile.close();
    }
    /*
     * Evaluates matrix & returns a boolean verdict
     * of whether the matrix is a magic square.
     * A magic square is valid if each row, column,
     * and diagonal sum to the same value.
     * Also, the matrix must contain all integers
     * from 1 to n^2 exactly once.
     * 
     * Expl:
     * n = 3, 3^2 = 9
     * 4 9 2
     * 3 5 7
     * 8 1 6
     */

    public boolean isMagicSquare() {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int targetSum = n * (n * n + 1) / 2;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != targetSum || colSum != targetSum) {
                return false;
            }

        }
        int diagSum1 = 0;
        int diagSum2 = 0;
        for (int i = 0; i < n; i++) {
            diagSum1 += matrix[i][i];
            diagSum2 += matrix[i][n - 1 - i];
        }
        if (diagSum1 == targetSum && diagSum2 == targetSum) {
            
            if (matrix[0][0] == matrix[0][1]) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    // Returns a copy of the matrix as a 2D array of integers
    public int[][] getMatrix() {
        int n = matrix.length;
        int[][] copyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        return copyMatrix;
    }

    /**
     * Returns a string formatted as in these examples:
     * The matrix
     * 4 9 2
     * 3 5 7
     * 8 1 6
     * is a magic square.
     * 
     * or
     * 
     * The matrix
     * 5 3 7
     * 9 4 2
     * 1 6 5
     * is not a magic square.
     */

    public String toString() {
        String result = "The matrix\n";
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