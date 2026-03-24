package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // create a new buffered reader
        System.out.println("Enter the number of elements in the array");
        int n = Integer.parseInt(br.readLine());    // read the number of elements
        int[] arr = new int[n];    // create an array of size n
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());    // read the elements of the array
        }
        System.out.println("The unsorted array is: " + Arrays.toString(arr));
        SelectionSort.selectionSort(arr);    // call the selection sort method
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {

        // Method - 1
//        int sortedIndex = 0;
//        int comparisonCount = 0;    // count the number of comparisons
//        int swapCount = 0;  // count the number of swaps
//        for (int i = 0; i < arr.length; i++) {  // loop through the array
//            sortedIndex = findMinIndex(arr, sortedIndex);    // find the minimum element in the unsorted part of the array
//            swap(arr, sortedIndex, i);  // swap the minimum element with the element at the sortedIndex
//            swapCount++;
//            comparisonCount++;
//        }
//        System.out.println("The sorted array is: " + Arrays.toString(arr));
//        System.out.println("Number of comparisons: " + comparisonCount);
//        System.out.println("Number of swaps: " + swapCount);

        // Method - 2
        int comparisonCount = 0; // count the number of comparisons
        int swapCount = 0;  // count the number of swaps
        for (int i = 0; i < arr.length - 2; i++) {
            int minIndex = i;
            // find the minimum element index in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
                comparisonCount++;
            }
            // swap the minimum element with the element at the sortedIndex
            if (minIndex != i) {    // if the minimum element is not at the sortedIndex
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swapCount++;
            }
            System.out.println("Iteration: " + i + ": " + Arrays.toString(arr));
        }

        System.out.println();
        System.out.println("The sorted array is: " + Arrays.toString(arr));
        System.out.println("Number of comparisons: " + comparisonCount);
        System.out.println("Number of swaps: " + swapCount);
    }

    private static void swap(int[] arr, int sortedIndex, int minIndex) {
        int temp = arr[sortedIndex];
        arr[sortedIndex] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private static int findMinIndex(int[] arr, int sortedIndex) {
        int minIndex = sortedIndex;
        for (int i = sortedIndex + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}