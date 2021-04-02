/* *****************************************************************************
 *  Name:    Alan Turing
 *
 *  Description:  Computes the product of an array of +/- 1 recursively by 
 *         dividing the array into two halves and computing the product for
 *         each half.  This approach has a linear order of growth because even 
 *         though we are dividing the problem in half each time, we still have to 
 *         deal with each half separately so we'll end up with N arrays of size 1 
 *         and we'll be doing N-1 multiplications
 *
 **************************************************************************** */

public class OneProduct {

    public static int oneProduct(int[] array) {
        return oneProduct(array, 0, array.length);
    }

    private static int oneProduct(int[] array, int lo, int hi) {
        int size = hi - lo;
        if (size == 1) {
            return array[lo];
        }
        int mid = (lo + hi) / 2;
        return oneProduct(array, lo, mid) * oneProduct(array, mid, hi);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, -1, -1, -1 };
        int test = oneProduct(arr1);
        System.out.println(test);
        int n = Integer.parseInt(args[0]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(2) * 2 - 1;
        }
        long start = System.currentTimeMillis();
        int result = oneProduct(arr);
        long msecs = System.currentTimeMillis() - start;
        System.out.println("Result is " + result);
        System.out.println("Time was " + msecs + " msecs");
    }
}
