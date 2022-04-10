Introduction:
KWIC (Key Word In Context) index system provides a search mechanism for information in a long list of lines. 
Our team explored and implemented two architectural design which are Main Program Subroutine with Shared Data and Pipes and Filters in our program.
We are using IntelliJ IDEA as the IDE. Please install IntelliJ IDEA before you run the Java code: https://www.jetbrains.com/idea/download/#section=windows

Requirements:
1. Functional:
a. The program should be able to display a list of KWIC to user.
b. The program is able to perform circular shifting and sorting of entries.

2. Non-functional:
a. The program should be implemented in Java language.
b. The program allows input from keyboard or text files.

Instruction to run the Java code in IntelliJ IDEA:

Assignment 1:

Main Program Subroutine with Shared Data:
1. Locate the test cases folder under file directory: C:\test.
2. Change the input file directory to "C:\test\testcase1\TitlesInput1.txt" under main class.
3. Change the output file directory to "C:\test\testcase1\out.txt" under main class
4. Build the solution and run the Main class. If there is no error, you should be able to see the out.txt under file directory C:\test\testcase1.

Pipes and Filters:
1. Locate the test cases folder under file directory: C:\test.
2. Change the input file directory to "C:\test\testcase1\TitlesInput1.txt" under main class.
3. Change the output file directory to "C:\test\testcase1\out2.txt" under main class
4. Build the solution and run the Main class. If there is no error, you should be able to see the out2.txt under file directory C:\test\testcase1.

Assignment 2:
Extension 1:
1. Locate the test cases folder under file directory: C:\test.
2. Change the input file directory to "C:\test\Test1\Titles1.txt" under main class.
3. Change the inputIgnore file directory to "C:\test\Test1\Ignored1.txt" under main class.
4. Change the inputRequired file directory to "C:\test\Test1\Required1.txt" under main class.
5. You can leave the Required1.txt blank, because we don't use this file in extension1. But this file must exist.
6. Change the output file directory to "C:\test\Test1\OutA.txt" under main class
7. Build the solution and run the Main class. If there is no error, you should be able to see the OutA.txt under file directory C:\test\Test1.

Extension 2:
1. Locate the test cases folder under file directory: C:\test.
2. Change the input file directory to "C:\test\Test1\Titles1.txt" under main class.
3. Change the inputIgnore file directory to "C:\test\Test1\Ignored1.txt" under main class.
4. Change the inputRequired file directory to "C:\test\Test1\Required1.txt" under main class.
5. Change the output file directory to "C:\test\Test1\OutA.txt" under main class
6. Build the solution and run the Main class. If there is no error, you should be able to see the OutA.txt under file directory C:\test\Test1.

Assignment 3:
1. Locate the test cases folder under file directory: C:\test.
2. Change the two input files directory to "C:\\test\\testing1\\CourseTitles.txt", "C:\\test\\testing1\\MovieTitles.txt" under Main class.
3. At the printFirstOutput class, go the System.out.println("Science1.txt"), and ensure "CourseTitles.txt" is inside the bracket.
4. At the printSecondtOutput class, go the System.out.println("Science2.txt"), and ensure "MovieTitles2.txt" is inside the bracket.
5. At the output class, ensure String first is equal to "CourseTitles.txt" and String second is equal to "MovieTitles.txt".
6. Build the solution and run the Main class. 
7. if the build is successful, user can see "Welcome to KWIC! Please input the word to be search: " at the console, type your word to be search under "Please input the word to be search:". Only one word to be input at one time.
8. Once found, the names of the files containing the input word should be displayed, followed by the context in which the word appears. 
9. Once the results of a search have been displayed, the user should be allowed to enter another word, until keyword “q” (quit) is entered. 