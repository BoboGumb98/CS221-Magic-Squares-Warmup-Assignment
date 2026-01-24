********************************************
* Magic Squares (warmup project)
* BSU CS221 Computer Science II (Mason Vail)
* 15Jan2025 - 23Jan2025
* Brolen Gumb
********************************************

OVERVIEW:

 This program generates or verifies a 'magic square' using an 
 inputted file or command line inputs. It verifies that each row, 
 column & both diagonals add to the same constant number as 
 well as that all numbers are unique. *Only works for odd numbers*.


INCLUDED FILES:

 * MagicSquare.java - The logic class that handles matrix generation, file reading/writing, & validation
 * MagicSquareDriver.java - Main interface, runs MagicSquare.java to create new object
 * MagicSquareInterface.java - Defines the interface for the MagicSquare class, providing required methods
 * MagicSquaresTest.java - Tester for the MagicSquare.java file
 * README - this file
 * Various testing files to verify via the MagicSquaresTest.java file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac MagicSquareDriver.java

 Run the compiled class file with the command:
 $ java MagicSquareDriver <filename>.txt <dimension>

 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 The MagicSquare program concists of two overloaded constructors, 
 two utility methods, a verification method & one 'get' method.

 The MagicSquare program begins at the MagicSquareDriver whose
 main method accepts two possible inputs, a filename string & a 
 dimension integer. Once recieved, are then passed to 
 the MagicSquare class & into one of two overloaded constructors.

 If a dimension is inputted the second constructor is called & a magic
 square is created from an algorithm within it's body. Next the writeMatrix
 method is given the matrix & filename where a file is created with the 
 provided inputs.

 If only a filename is inputted, the first constructor passes the string name & 
 passes it to readMatrix() method which reads the file, verifies that it is not
 empty & copies the matrix to a 2D integer array which it then returns.

 Once the MagicSquare() method is completed, the magicsquare is then sent to the toString()
 method to begin its printing to the terminal, it immediately attempts to verify
 each row, column, & diagonal path sum is equal to the same integer by calling the isMagicSquare()
 method where the results are then posted to the terminal. Also that the inputed data is formatted corectly & not null.

 To verify if the matrix is a magic square, a formula is used within isMagicSquare() method:
                n((n^2)+1)/2


TESTING:
 
 Method 1: MagicSquaresTest.java is a testing file to verify the programs functunality, 
 8 test methods are ran, each multiple times for a total of 45. They include;
    constructorTest()
    getMatrixTest()
    isMagicSquareTest() <valid> / <invalid> (3x3-6x6)
    toStringTest()
    getMatrixEncapsulationTest()
    noSuchFileTest()
    validOutputFormatTest()
    printTest()

 Method 2: inputing 'java MagicSquareDriver <filename>.txt <dimension>' into the terminal
 & checking the output.


DISCUSSION:
 
 One issue remains, on line 141 of the tester program the printTest result for
 validOutputFormatTest() is still failing, the size dimension is passed in as a 3, 
 however through some process it is being changed to a 5. I believe that it is due 
 to an improper call of a previous variable value from an earlier test. Unfortunately,
 I am not skilled enough to identify where it is, a CS221 LA also attempted to assist
 during a session in the KLC with no luck. Unfortunately 44/45 is the best I was able 
 to do before the deadline.
 To identify this issue, I created a breakpoint in line 141, & ran the debugger. 
 I stepped in to line 331 & stepped over until stepping into line 336. Which took me 
 into the MagicSquare class to the getMatrix() methed where the value for the integer 'n'
 is equal to 5, when it should be a '3'.

 The hardest part of every program is always the initial start of its creation. Even 
 with psudocode, after the outline/skeleton layout, mapping out the programs logic
 is like stacking cups. You start building but quickly realize you're missing some crucial
 variable or aspect that is essential to the entire program working.