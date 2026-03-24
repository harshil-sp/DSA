package SlidingWindow.WindowSizeK;

/* Problem statement
 * Given an array of integers a, and a positive integer k, find the first negative integer for each and every window
 * (contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.
 *
 * Example 1
 * Input: a[] = {-5, 1, 2, -6, 9}, k = 2
 * Output : -5 0 -6 -6
 * Explanation: First negative integer in every window of size 2
 * {-5, 1} = -5
 * {1, 2} = 0 (does not contain a negative integer)
 * {2, -6} = -6
 * {-6, 9} = -6
 *
 * Example 2
 * Input : a[] = {10, -1, -5, 7, -15, 20, 18, 24} , k = 3
 * Output : -1 -1 -5 -15 -15 0
 * Explanation: First negative integer in every window of size 3
 * {10, -1, -5} = -1
 * {-1, -5, 7} = -1
 * {-5, 7, -15} = -5
 * {7, -15, 20} = -15
 * {-15, 20, 18} = -15
 * {20, 18, 24} = 0 (does not contain a negative integer)
 *
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FirstNegativeSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int k = in.nextInt();

        int[] result = firstNegativeSubArray(arr, k);
        System.out.println(Arrays.toString(result));
    }

//    Brute Force = https://www.callicoder.com/first-negative-number-in-every-window-of-size-k/

    private static int[] firstNegativeSubArray(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        int i = 0;
        ArrayList<Integer> negativeNumber = new ArrayList<>();

        int windowStart = 0;
        int windowEnd = 0;
        while (windowEnd < arr.length) {
            if (arr[windowEnd] < 0) {
                negativeNumber.add(arr[windowEnd]);
            }

            if (windowEnd - windowStart + 1 < k) {
                windowEnd++;
            } else if (windowEnd - windowStart + 1 == k) {
                if (negativeNumber.isEmpty()) {
                    result[i++] = 0;
                } else {
                    result[i++] = negativeNumber.get(0);
                    if (arr[windowStart] == negativeNumber.get(0)) {
                        negativeNumber.remove(0);
                    }
                    windowStart++;
                }
                windowEnd++;
            }
        }
        return result;
    }
}
