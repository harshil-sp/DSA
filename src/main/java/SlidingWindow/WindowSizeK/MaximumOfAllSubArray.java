package SlidingWindow.WindowSizeK;

/* Problem statement
 * Given an array of integers a, and an integer k, find the maximum for each and every contiguous subarray of size k.
 *
 * Example
 * Input: a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of subarray {1, 2, 3} is 3
 * Maximum of subarray {2, 3, 1} is 3
 * Maximum of subarray {3, 1, 4} is 4
 * Maximum of subarray {1, 4, 5} is 5
 * Maximum of subarray {4, 5, 2} is 5
 * Maximum of subarray {5, 2, 3} is 5
 * Maximum of subarray {2, 3, 6} is 6
 * */


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaximumOfAllSubArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int arraySize = input.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = input.nextInt();
        }

        int windowSize = input.nextInt();

        int[] result = maximumOfAllSubArray(array, windowSize);
        System.out.println("Maximum subarray elements: " + Arrays.toString(result));

    }

    private static int[] maximumOfAllSubArray(int[] array, int k) {
        int[] result = new int[array.length - k + 1];
        int r = 0;
        Stack<Integer> maxElements = new Stack<>();

        int maxElement = Integer.MIN_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            if (array[windowEnd] > maxElement) {
                maxElement = array[windowEnd];
            }

            if (windowEnd - windowStart + 1 == k) {
                if (!maxElements.contains(maxElement))
                    maxElements.add(maxElement);
                result[r++] = maxElements.peek();
                if (maxElement == array[windowStart]) {
                    if (array[windowStart + 1] > array[windowEnd]) {
                        maxElement = array[windowStart + 1];
                    } else {
                        maxElement = array[windowEnd];
                    }
                }
                windowStart++;
            }
        }

        return result;
    }

//    source = https://www.callicoder.com/sliding-window-maximum/
    // Brute Force technique
    private static int[] maxOfAllSubarray_BruteForce(int[] a, int k) {
        int n = a.length;
        int[] maxOfSubarrays = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i <= n - k; i++) {
            int maxElement = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (maxElement < a[j]) {
                    maxElement = a[j];
                }
            }
            maxOfSubarrays[idx++] = maxElement;
        }
        return maxOfSubarrays;
    }
}
