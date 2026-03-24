package SortingAnalysis;

import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
    private static int cnt = 0;
    private static void simpleMerge(int[] a, int first, int second, int third) {
        int i = first;
        int j = second;
        int index = -1;
        cnt += 3;

        int[] temp = new int[a.length];
        cnt += 2;
        while (i<second && j<=third) {
            cnt ++;
            if(a[i]<=a[j]) {
                index ++;
                temp[index] = a[i];
                i ++;
                cnt += 4;
            } else {
                index ++;
                temp[index] = a[j];
                j ++;
                cnt += 4;
            }
        }

        cnt ++;
        if(i >= second) {
            cnt ++;
            while (j <= third) {
                cnt += 4;
                index ++;
                temp[index] = a[j];
                j ++;
            }
        } else {
            cnt ++;
            while (i<second) {
                cnt += 4;
                index ++;
                temp[index] = a[i];
                i ++;
            }
        }

        cnt ++;
        for (i = first; i<=third; i++) {
            cnt ++;
            a[i] = temp[i-first];
        }
    }

    private static void TwoWayMergeSort(int[] data, int start, int finish) {
        // compare the size of the current subtable...
        int size =  finish-start+1;

        // test base condition...
        if (size <= 1) {
            return;
        }

        // calculate mid point...
        int middle = start + (int)Math.floor(size/2)-1;
        // recursively sort first subtable...
        TwoWayMergeSort(data, start, middle);
        TwoWayMergeSort(data, middle+1, finish);
        // merge two ordered subtables....
        simpleMerge(data, start, middle+1, finish);
    }

    public static void main(String[] args) throws IOException {
        InterfaceMaker Interface = new InterfaceMaker("SortingAnalysis//Inputs");
        BufferedReader scanner = new BufferedReader(Interface.getFile("MergeSortWorst.txt"));
        int T = Integer.parseInt(scanner.readLine());
        while (T > 0) {
            String[] inp = scanner.readLine().split(" ");
            int[] data = new int[inp.length];
            for (int i=0; i<data.length; i++) {
                data[i] = Integer.parseInt(inp[i]);
            }
            TwoWayMergeSort(data, 0, data.length-1);
            System.out.println("Sorted Data : "+Arrays.toString(data)+" With comparisions : "+cnt);
            cnt = 0;
            T --;
        }
    }
}
