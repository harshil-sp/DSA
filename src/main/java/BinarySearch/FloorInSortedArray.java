package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FloorInSortedArray {
    public static void main(String[] args) {
    }

    public int findFloor(int[] arr, int x) {
        // code here
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
