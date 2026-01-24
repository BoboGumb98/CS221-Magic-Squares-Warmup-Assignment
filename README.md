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
 well as that all numbers are unique. Only works for odd numbers.


INCLUDED FILES:

 * MagicSquare.java - The logic class that handles matrix generation, file reading/writing, & validation
 * MagicSquareDriver.java - Main interface, runs MagicSquare.java to create new object
 * MagicSquareInterface.java - Defines the interface for the MagicSquare class, providing required methods
 * MagicSquaresTest.java - Tester for the MagicSquare.java file
 * README - this file


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

 To verify if the matrix is a magic square, a formula is used:
                n((n^2)+1)/2


TESTING:

 What was the testing strategy? What kinds of tests were run?
 Can your program handle bad input? Is your program idiot-proof? How do you 
 know? What are the known issues / bugs remaining in your program?

 
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
 
 Discuss the issues you encountered during programming (development)
 and testing. What problems did you have? What did you have to research
 and learn on your own? What kinds of errors did you get? How did you 
 fix them?
 
 What parts of the project did you find challenging? Is there anything
 that finally "clicked" for you in the process of working on this project?

 The hardest part of every program is always the initial start of the program
 creation. Even with psudocode, after the outline/skeleton layout, mapping out 
 the programs logic