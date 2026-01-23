import java.io.IOException;

/**
 * 
 * 
 * 
 * @author Brolen Gumb
 * @version 1.0
 */

public class MagicSquareDriver {

    public static void main(String[] args) throws IOException {

        String filename = args[0];
        int dimension = Integer.parseInt(args[1]);
        
        MagicSquare magicSquare = new MagicSquare(filename, dimension);

        System.out.println(magicSquare.toString());
        
        
    }
}