package SlidingWindow.WindowSizeK;

/* Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous sub array of
*  size k.
*
* Example - 1
* Input: [3, 5, 2, 1, 7], k=2
* Output: 8
* Explanation: Sub array with maximum sum is [1, 7].
*
* Example - 2
* Input: a[] = {4, 2, 3, 5, 1, 2}, k = 3
* Output: 10
* Explanation: Sub array with maximum sum is [2, 3, 5]
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // array as string
        System.out.println("Enter array element: ");
        String[] t = bufferedReader.readLine().split(" ");
        System.out.println(Arrays.toString(t));

        // creating an int array
        int[] array = new int[t.length];
        // converting String array to int array
        for (int i = 0; i < t.length; i++) {
            array[i] = Integer.parseInt(t[i]);
        }
//
        // window size
        System.out.println("Enter window size: ");
        int k = Integer.parseInt(bufferedReader.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;


//        for (int i = 0; i < k; i++) {
//            sum += array[i];
//        }
//        for (int i = k; i < array.length; i++) {
//            sum = sum + array[i] - array[i - k];
//            if (sum > max) {
//                max = sum;
//            }
//        }

        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd]; // Add the next element to the window

            if (windowEnd - windowStart + 1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                max = Math.max(max, windowSum);
                windowSum -= array[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window
            }
        }

        System.out.println("Max sum = " + max);
    }

//    for more: https://www.callicoder.com/maximum-sum-subarray-of-size-k/
}
