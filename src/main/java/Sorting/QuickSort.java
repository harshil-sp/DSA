package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 45, 4, 78, 8, 23, 99, 9, 64, 11, 43};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


//    // Implementation of the QuickSort algorithm
//    public static void quickSort(int[] array) {
//        sort(array, 0, array.length - 1);
//    }
//
//    private static void sort(int[] array, int left, int right) {
//        if (left < right) {
//            int pivot = partition(array, left, right);
//            sort(array, left, pivot - 1);
//            sort(array, pivot + 1, right);
//        }
//    }
//
//    private static int partition(int[] array, int left, int right) {
//        int pivot = array[right];
//        int i = left;
//        for (int j = left; j < right; j++) {
//            if (array[j] <= pivot) {
//                swap(array, i, j);
//                i++;
//            }
//        }
//        swap(array, i, right);
//        return i;
//    }
//
//    private static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

    public static void quickSort(int[] array, int left, int right) {
        boolean flag = true;
        int i = left;
        int j = right + 1;
        int key = array[left];

        if (left < right) {


            while (flag) {
                i = i + 1;
                while (array[i] < key) {
                    i = i + 1;
                }
                j = j - 1;
                while (array[j] > key) {
                    j = j - 1;
                }
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else
                    flag = false;
            }

            int temp1 = array[left];
            array[left] = array[j];
            array[j] = temp1;

            System.out.println(Arrays.toString(array));
            quickSort(array, left, j - 1);
            quickSort(array, j + 1, right);
        }
    }
}
