//package Helper;
//
//import Practical2.DataGenerator;
//
//public final class QuickSortBestCase
//{
//    public static void generate(int[] arr, int begin, int end)
//    {
//        int count = end - begin;
//        if(count < 3)
//            return;
//
//        //Find a middle element index
//        //This will be the pivot element for the part of the array [begin; end)
//        int middle = begin + (count - 1) / 2;
//
//        //Make the left part best-case first: [begin; middle)
//        generate(arr, begin, middle);
//
//        //Swap the pivot and the start element
//        swap(arr, begin, middle);
//
//        //Make the right part best-case, too: (middle; end)
//        generate(arr, ++middle, end);
//    }
//
//    private static void swap(int[] arr, int i, int j)
//    {
//        int t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
//
//    private static void fillArray(int[] arr)
//    {
//        for(int i = 0; i != arr.length; ++i)
//            arr[i] = i + 1;
//    }
//
//    private static void printArray(int[] arr)
//    {
//        for(int item : arr)
//            System.out.print(item + " ");
//    }
//
//    public static int[] generateWorst(int n) {
//        return DataGenerator.getWorst(n);
//    }
//
//    public static int[] generateBest(int n)
//    {
//        int intCount = n;
//        int[] arr = new int[intCount];
//
//        //We basically do what quicksort does in reverse
//        //1. Fill the array with sorted values from 1 to arr.length
//        fillArray(arr);
//        //2. Recursively generate the best-case array for quicksort
//        generate(arr, 0, arr.length);
//
//        return arr;
//    }
//}
