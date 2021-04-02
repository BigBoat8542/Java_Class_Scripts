/*   CS 121 2018   LAB QUIZ 1   

Instructions: 
0) Read all of these instructions!
1) Read the problem statement below and the examples
2) Design a solution to the problem
3) Write the code for your solution and debug your program - you may find it
   useful to create a test input file
4) Write your name and a description of your solution in the comment block
   above the code
5) Submit just your Java file on Moodle - don't change the name of your class 
   or file; it must be "Histogram.java"

Problem: Given a file full of test scores which are between 0 and 99, we want to
see how many scores fall in the range between 0 to 9, how many fall between 10
to 19, and so on, up to 90 to 99.  Each range is called a "bucket" and there are
10 buckets.

The program given below currently just reads numbers from a file (which is a
command-line argument) and prints them out.  Your task is to modify the program
so that it counts how many scores fall into each of the ten buckets and print
out (to the standard output) the ranges with their totals.  Such a display is
called a "histogram."

For example, suppose the file contains the scores: 85 65 77 92 93 88 84

After running $java-introcs Histogram simple.txt

your output should look like this:

Bucket 0   0 to 9: 0
Bucket 1   10 to 19: 0
Bucket 2   20 to 29: 0
Bucket 3   30 to 39: 0
Bucket 4   40 to 49: 0
Bucket 5   50 to 59: 0
Bucket 6   60 to 69: 1
Bucket 7   70 to 79: 1
Bucket 8   80 to 89: 3
Bucket 9   90 to 99: 2

Note that the scores in the file may be in any order.

For the test input file, scores.txt, the correct output is:
Bucket 0   0 to 9: 0
Bucket 1   10 to 19: 5
Bucket 2   20 to 29: 0
Bucket 3   30 to 39: 15
Bucket 4   40 to 49: 10
Bucket 5   50 to 59: 10
Bucket 6   60 to 69: 15
Bucket 7   70 to 79: 15
Bucket 8   80 to 89: 24
Bucket 9   90 to 99: 15

*/

/*   

Name:  Ken Basye

Maintain buckets in an array of 10 ints, initially they’ll all be 0 and we’ll add 1
for each score that falls into that bucket.  When the input is done, we’ll print out the counts for each bucket as shown in the problem statement.

*/


public class Histogram {

    public static void main(String[] args) {
        In infile = new In(args[0]);

        int[] result = new int[10];  // These are the 10 buckets we use to count scores
        while( ! infile.isEmpty() ) {
            int value = infile.readInt();
	    // Using integer division makes values from 0-99 into indices from 0-9.
            result[value/10]++;  // Increase count of the correct bucket.
        }

	// Now generate the output as shown
        for(int i = 0; i < 10; i++) {
            StdOut.println(i* 10 + " to " + (i * 10 + 9) + ": " + result[i]);
        }
    }
}
