package SlidingWindow.VariableSize;

/* Problem Statement
 * Given an array of positive integers array and a positive number K, find the length of the largest contiguous subarray
 * whose sum is equal to K. Return 0 if no such subarray exists.
 *
 * Example 1
 * Input: a = [2, 1, 4, 3, 2, 5], K = 7
 * Output: 3
 *
 * Example 2
 * Input: [3, 4, 1, 1, 6], K = 8
 * Output: 3
 *
 * Example 3
 * Input: a = [1, 3, 2, 1, 5], K = 15
 * Output: 0
 * */

import java.util.Scanner;

public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        Taking the size array
        System.out.println("Enter size of an array: ");
        int size = input.nextInt();

//        taking array elements
        int[] array = new int[size];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

//        taking k for sum
        System.out.println("Enter the value of sum: ");
        int sum = input.nextInt();

        int maxWindowSize = largestSubArrayOfSumK(array, sum);
        System.out.println("Largest subarray size is: " + maxWindowSize);
    }

    //    method for finding size of the largest subarray
    private static int largestSubArrayOfSumK(int[] array, int k) {
//        to keep track of the largest subarray
        int maxWindowSize = 0;
        int sum = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
//          calculate the sum of elements
            sum += array[windowEnd];

//            if (sum == k) {
//                maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
//                if (maxWindowSize != 1) {
//                    sum -= array[windowStart];
//                    windowStart++;
//                }
//            }
//            if (sum > k ) {
//                sum -= array[windowStart];
//                windowStart++;
//            }

            while (sum > k) {
                sum -= array[windowStart];
                windowStart++;
            }

            if (sum == k) {
                maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
            }
        }
        return maxWindowSize;
    }
}
