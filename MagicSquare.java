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

    }

    // Evaluates matrix & returns a boolean verdict of whether the matrix is a magic square.
    public boolean isMagicSquare() {

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