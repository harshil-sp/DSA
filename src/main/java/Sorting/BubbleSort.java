package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BubbleSort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // create a buffered reader

        System.out.println("Enter the number of elements in the array");
        int n = Integer.parseInt(br.readLine());    // read the number of elements
        int[] arr = new int[n];    // create an array of size n

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());    // read the elements of the array
        }

        BubbleSort bs = new BubbleSort();    // create a new instance of the class
        int[] sortedArr = bs.bubbleSort(arr);    // call the bubbleSort method

        System.out.println("\nSorted array is: ");
        for (int i = 0; i < n; i++) {    // print the sorted array
            System.out.print(sortedArr[i] + " ");
        }
    }

    // bubbleSort logic
    public int[] bubbleSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {        // outer loop
            for (int j = 0; j < arr.length - 1 - i; j++) {    // inner loop
                if (arr[j] > arr[j + 1]) {  // if the current element is greater than the next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;    // increment the swap counter
                }
                comparisons++;    // increment the comparison counter
            }
            if (swaps == 0) {
                break;    // if no swaps are made, break out of the outer loop
            }
        }

        System.out.println("Number of comparisons: " + comparisons);    // print the number of comparisons
        System.out.println("Number of swaps: " + swaps);    // print the number of swaps

        for (int j : arr) {    // print the sorted array
            System.out.print(j + " ");
        }

        return arr;    // return the sorted array
    }
}
