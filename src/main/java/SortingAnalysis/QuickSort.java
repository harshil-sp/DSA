package SortingAnalysis;

import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {
    private static int cnt = 0;
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void quickSort(int lb, int ub, int[] data) {
        // setting the flag as true, that the i < j
        boolean flag = true;
        cnt ++;

        // lower bound is less than upper bound...
        cnt ++;
        if(lb < ub) {
            int i = lb;
            int j = ub+1;
            int key =  data[lb];

            cnt += 4;
            while (flag) {
                cnt ++;
                i++;
                while (data[i] < key && i< data.length-1) {
                    cnt ++;
                    i++;
                }
                j--;
                cnt ++;
                while (data[j] > key) {
                    cnt ++;
                    j--;
                }

                cnt++;
                if (i < j) {
                    swap(data, i, j);
                    cnt += 3;
                } else {
                    cnt += 4;
                    flag = false;
                    swap(data, lb, j);
                }
            }

            quickSort(lb, j-1, data);
            quickSort(j+1, ub, data);
        }
    }

    public static void main(String[] args) throws IOException {
        InterfaceMaker im = new InterfaceMaker("SortingAnalysis//Inputs");
        BufferedReader scanner = new BufferedReader(im.getFile("QuickSortWorst.txt"));
        int T = Integer.parseInt(scanner.readLine());
        while (T > 0) {

            String[] inp = scanner.readLine().split(" ");
            int[] data = new int[inp.length];
            for (int i=0; i<inp.length; i++) {
                data[i] = Integer.parseInt(inp[i]);
            }

            System.out.println("Input array is : "+Arrays.toString(data));
            quickSort(0, data.length-1, data);
            System.out.println("Sorted Array is : "+Arrays.toString(data));
            System.out.println("Count taken : "+cnt);
            cnt = 0;
            T --;
        }
    }
}
