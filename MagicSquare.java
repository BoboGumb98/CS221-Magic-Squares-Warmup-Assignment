/**
 * 
 * @author Brolen Gumb
 * @version 1.0
 * 
*/


public class MagicSquare implements MagicSquareInterface {

    public MagicSquare 

    Scanner scnr = new Scanner();
    Scanner lineScnr = new Scanner();
    
    // Constructor takes filename & attempts to read that file
    private int[][] readMatrix(String filename) throws FileNotFoundException {

    }

    // Constructor takes filename & dimension integer
    public MagicSquare(String filename, int dimension) throws IOException {
        File file = new File(filename);
        PrintWriter outFile = new PrintWriter(new FileWriter(file));

        int n =  dimension * dimension;
        int[][] matrix = new Array[dimension][dimension];
        int row = n - 1;
        int col = n / 2;
        int oldRow = row;
        int oldCol = col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]

            }
        }

        if(int[][] != 0) {
            row = oldRow;
            col = oldCol;
            row--;
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
        if () {
            return true;
        } else {
            return false;
        }
    }

    // Returns a copy of the matrix as a 2D array of integers
    public int[][] getMatrix() {

    }

    /**
     *  Returns a string formatted as in these examples:
     *   The matrix
	 *     4 9 2
	 *     3 5 7
	 *     8 1 6
	 *   is a magic square.
	 *  or
	 *    The matrix
	 *      5 3 7
	 *      9 4 2
	 *      1 6 5
	 *    is not a magic square.
     */

    public String toString() {
        System.out.println("The matrix");
        System.out.println();

        if () {
            System.out.print("is a magic square");
        } else {
            System.out.print("is not a magic square");
        }
    }
}