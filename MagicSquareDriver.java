import java.io.IOException;

/**
 * The MagicSquareDriver class serves as the entry point for creating a new
 * magic square of a specified odd dimension and displaying its contents
 * by utilizing the MagicSquare class.
 * 
 * @author Brolen Gumb
 * @version 1.7
 */

public class MagicSquareDriver {

    public static void main(String[] args) throws IOException {

        String filename = args[0];
        int dimension = Integer.parseInt(args[1]);
        
        MagicSquare magicSquare = new MagicSquare(filename, dimension);

        System.out.println(magicSquare.toString());
        
    }
}