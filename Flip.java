/*   CS 121 2017   LAB QUIZ 1   

Instructions: 
0) Read all of these instructions!
1) Read the problem statement below and the examples
2) Design a solution to the problem
3) Write the code for your solution and debug your program - you may find it
   useful to create a test input file
4) Write your name and a description of your solution in the comment block
   above the code
5) Submit just your Java file on Moodle - don't change the name of your class 
   or file; it must be "Flip.java"

Problem: The program given below currently just reads lines from the
standard input and prints them out.  Your task is to modify the program so that
it takes a non-negative integer argument N and prints the first N lines of input
in reverse order, then prints any remaining lines in forward order.  If fewer
than N lines of input are entered, they should all be printed in reverse order.  
NOTE: The examples below all use input consisting of 5 lines, but your program 
should (of course) make no assumptions about how many lines of input will be given.

Examples:  Suppose lines.txt contains the following 5 lines:
one 1
two 2
three 3
four 4 
five 5

Then your output should look like this:

java Flip 1 < lines.txt
one 1
two 2
three 3
four 4 
five 5

java Flip 2 < lines.txt
two 2
one 1
three 3
four 4 
five 5

java Flip 4 < lines.txt
four 4 
three 3
two 2
one 1
five 5

java Flip 6 < lines.txt
five 5
four 4 
three 3
two 2
one 1

*/

/*   

Name: Ken Basye

Store the lines to be flipped in an array of Strings.  Once N lines have been read, print them out in flipped order, then print any remaining lines in regular order.
*/

public class Flip {

    public static void main(String[] args) {
        int numToFlip = Integer.parseInt(args[0]);
        int linesRead = 0;
        String[] lineStore = new String[numToFlip];

	// Read and store lines to flip - no printing yet!  Break out if we either 
	// hit the number of lines to flip or we run out of input.
        while( StdIn.hasNextLine() && linesRead < numToFlip) {
            String line = StdIn.readLine();
            lineStore[linesRead] = line;
            linesRead++;
        }
        
	// Print out the stored lines in flipped order
        for(int i = 0; i < linesRead; i++) {
	    // This index math gets us the last line first, then works backward
            StdOut.println(lineStore[linesRead - i -1]);
        }
	
	// If there’s more to print than the flipped part, just read and print each line
        while( StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            StdOut.println(line);
        }
    }
}
