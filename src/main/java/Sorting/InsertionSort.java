package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // create a buffered reader

        System.out.println("Enter the number of elements in the array");
        int n = Integer.parseInt(br.readLine());    // read the number of elements
        int[] arr = new int[n];    // create an array of size n

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());    // read the elements of the array
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);    // call the insertion sort method

    }

    // Insertion Sort
    public void insertionSort(int[] arr) {
        int swaps = 0;
        //insertion sort
        for (int i = 1; i < arr.length; i++) {   // i = 1 because we already know the first element is sorted
            int current = arr[i];         // current = the element we are looking at
            int j = i - 1;              // j = the index of the element before the current element
            while (j >= 0 && arr[j] > current) { // while j is greater than 0 and the element before j is greater than current
                //Keep swapping the elements
                arr[j + 1] = arr[j];  // move the element after j to the right
                j--;    // decrement j
                swaps++;
            }
            arr[j + 1] = current; // insert the current element into the correct position
        }

        System.out.println("Number of swaps: " + swaps);    // number of swaps is equal to the number of comparisons
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));  // print the sorted array
    }
}
