
/*   CS 121 2019   LAB QUIZ 1

Instructions:
0) Read all of these instructions!
1) Read the problem statements below and the test code for each problem
2) Design a solution for each problem
3) Write the code for your solutions and debug your program - you may find it
   useful to extend the existing test code
4) Write a description of your solutions in a comment block above your code
5) Submit just your Java file by email to kebasye@clarku.edu - don't change the name of
   your class or file; it must be "LabQuiz1.java" - make sure you put your name in your
   file in the space provided!

Problem 1: Write a static function taking an array of doubles and returning an int.
Your function should return the number "zero-crossings", that is, the number
of times the consecutive values in the array go from strictly negative to strictly
positive or from strictly positive to strictly negative.  For example, if the array
holds {-1.0, 1.0, -1.0, -0.9} the number of zero-crossings is 2, one between elements
0 and 1, and one between 1 and 2.  An array of all positive values has no crossings at all.

Problem 2:  Write a static function taking an array of ints and returning an
array of ints of the same length, and with the same values in the same order as the input,
but with any 0 elements moved to the end of the array.  So if the input is {1, 0, 2, 3, 0, 4}
the return array should be {1, 2, 3, 4, 0, 0}.


Name: Luke Watson-Sharer

**************************************************************************** */

public class LabQuiz1 {
    public static void main(String[] args) {
        // testCrossings();
        System.out.println();
        // testMoveZeros();
    }

    public static void testCrossings() {
        double[] test1 = { 1.0, -1.0, 1.0, -1.0, 1.0 };
        double[] test2 = { 1.0, 1.0, 1.0, 1.0, 1.0 };
        double[] test3 = { 1.0, -1.0 };
        double[] test4 = { 1.0 };
        double[] test5 = { 1.0, -1.0, 0.0, -1.0, 1.0 };
        double[] test6 = { 1.0, -1.0, 0.0, -1.0, 1.0 };
        testOneArrayCrossings(test1);
        testOneArrayCrossings(test2);
        testOneArrayCrossings(test3);
        testOneArrayCrossings(test4);
        testOneArrayCrossings(test5);
        testOneArrayCrossings(test6);
    }

    public static void testMoveZeros() {
        int[] test1 = { 1, -1, 1, 0, 1 };
        int[] test2 = { 1, 1, 1, 1, 1 };
        int[] test3 = { 0, 0 };
        int[] test4 = { 0 };
        int[] test5 = { 0, 0, 0, -1, 1 };
        int[] test6 = { 0, 0, 0, -1, 1 };
        testOneArrayMoveZeroes(test1);
        testOneArrayMoveZeroes(test2);
        testOneArrayMoveZeroes(test3);
        testOneArrayMoveZeroes(test4);
        testOneArrayMoveZeroes(test5);
        testOneArrayMoveZeroes(test6);
    }

    public static void testOneArrayCrossings(double[] arr) {
        int c = countCrossings(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("has " + c + " crossings.");
    }

    public static void testOneArrayMoveZeroes(int[] arr) {
        int[] result = moveZeros(arr);
        System.out.print("Input array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("After moving, result is: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    /*
    Describe your solution here!
// English description of how to solve the problem
// I began by creating an integer that we will use to create a count of the crossings. Then I put that through the
 for loop so I can count each value in the array. I then used an if statement to test the condition of strictuly positibe and
 negative by making it lest than 0 so it'd be less than 0 znd then the values in which are said if all positive then
 no crossings. So then I increment it because It'll go through the other values and return the value. It has one small ";" isn't
 working against me but the logic shows that it'll replicate the problem

     */
    public static int countCrossings(double[] arr) {
        int a = countCrossings( double array[]);
        //int array[] = new int[arr.length]; potential backup idea
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + arr[1 + i] < 0) ; //might be multiplication
            a++;
        }
        return a;
    }
    /*
    Describe your solution here!
    //Write a static function taking an array of ints and returning an
    array of ints of the same length, and with the same values in the same order as the input,
    but with any 0 elements moved to the end of the array.  So if the input is {1, 0, 2, 3, 0, 4}
    the return array should be {1, 2, 3, 4, 0, 0}.
    // so here we begin with the problem I re added above. So we want to return somehting of the same length so
    the first things I did was create an array that would equal the original constructors array. This way this array would have
    the same value as the original array. So to fix the 0 elements to the end what I did was extend the test total,
    because extending the test total means that test6==test5 and would produce the same result in the next test and so on.
    How i performed that was creating an index keeping track of my new array's length which  would return when not equal
    and less than the first number in the index it'd return the same number. So then the next part I made a count so the array
    increments and then  tested for when it's incrementing and isn't the first value it would increase by one and move
    on to the next value. So I make another loop to deal with the 0 at the end. Variable l which is being a pain is meant to
    be less than the new arr because it'll test where it isn't 0 as the problem states. So I use an if else for if isn't this
    array's length it would return to the roiginal but if it's equal then it would have the same value. Finally I used another loop
    with value p which would return arr at index 0 so we can get back to the first number and test for the number to match
    the previous answer. It won't compule due to small errors I don't have time to fic but the jist is there. It'll return
    the final array value so that they can see if they're equal to the orignal
     */

    public static int[] moveZeros(int[] orig) {
        int[] arr = new int[orig.length];
        int index = arr.length;
        if (orig.length <= 1) {
            return orig;
        }
        int c = 0;
        if (orig.length <= 1) {
            for (int i = 1; i < arr.length; i++) {
                c++;

            }
        }
        for (l = 0; l < index; l++) {
            if (arr.length != 0) {
                arr[l] = orig[l];
            }
            else {
                arr[1] = orig[1];
            }
        }
        for (int p = index; p < arr.length; p++) {
            arr[p] = 0;
        }
        return arr;
    }

}
        }




