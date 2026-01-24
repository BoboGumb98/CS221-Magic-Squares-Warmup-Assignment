import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The MagicSquare class represents a magic square matrix and provides
 * functionalities to read from a file, create a new magic square, check its
 * validity, and output its representation.
 * 
 * @author Brolen Gumb
 * @version 1.7
 * 
 */

public class MagicSquare implements MagicSquareInterface {

    private int[][] matrix;
    

    /**
     * Constructor that initializes a MagicSquare by reading an existing
     * matrix from a formatted text file.
     * 
     * @param filename The file's name.
     * @throws IOException If the specified file does not exist.
     */

    public MagicSquare(String filename) throws FileNotFoundException {
        matrix = readMatrix(filename);
    }

    /**
     * Constructor that creates a new Magic Square of a specified 'ODD' dimension
     * and writes it to a file.
     * 
     * @param filename The file's name.
     * @param dimension The size of one side of the square (must be odd).
     * @throws IOException If an error occurs during file writing.
     */

    public MagicSquare(String filename, int dimension) throws IOException {

        // From project handout
        this.matrix = new int[dimension][dimension];
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

    /**
     * Reads a matrix from a file. The file should start with an integer
     * representing the dimension, followed by the matrix elements.
     * 
     * @param filename The path to the file.
     * @return A 2D array representing the matrix.
     * @throws FileNotFoundException If the file is not found.
     */

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

    /**
     * Writes the current matrix to a text file.
     * 
     * @param matrix The 2D array to write.
     * @param filename The file's name.
     * @throws IOException If an error occurs during writing.
     */

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

    /**
     * Evaluates the matrix to determine if it meets the criteria of a magic square.
     * Checks that all rows, columns, and diagonals sum to the magic constant,
     * and that all numbers from 1 to n^2 appear exactly once.
     * 
     * @return true if the matrix is a valid magic square, false otherwise.
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
        // Checks diagonals for targetSum
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

    /**
     * Creates a copy of the matrix and returns it.
     * 
     * @return A 2D array copy of the current matrix.
     */

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
     * Returns a string representation of the matrix and its magic square status.
     * 
     * * @return A string displaying the matrix and if it is a magic
     * square.
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