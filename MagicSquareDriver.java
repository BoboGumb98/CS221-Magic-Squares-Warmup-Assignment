
/**
 * 
 * 
 * 
 * @author Brolen Gumb
 * @version 1.0
 */

public class MagicSquareDriver {

    public static void main(String[] args) {
        try {
            MagicSquare magicSquareFromFile = new MagicSquare("magic3.txt");
            System.out.println("Magic Square read from file:");
            System.out.println(magicSquareFromFile);

            int dimension = 5; // Example dimension
            MagicSquare generatedMagicSquare = new MagicSquare("generatedMagic5.txt", dimension);
            System.out.println("Generated Magic Square of dimension " + dimension + ":");
            System.out.println(generatedMagicSquare);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}