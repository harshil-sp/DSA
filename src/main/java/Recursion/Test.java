package Recursion;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{11, 2, 5, 89, 12, 40, 11};
        reverseArray(array, 0);
        System.out.println("reverse array is: " + Arrays.toString(array));
    }

    private static void reverseArray(int[] array, int i) {
        if (i >= array.length / 2) {
            return;
        }
        swap(i, array.length - i - 1, array);
        reverseArray(array, i + 1);
    }

    private static void swap(int i, int i1, int[] array) {
        array[i] = array[i1] + array[i];
        array[i1] = array[i] - array[i1];
        array[i] = array[i] - array[i1];
    }

    public static void function(int i, int number) {
        if (i > number)
            return;
        function(i + 1, number);
        System.out.println(i);
    }

    public static int sumOfNNumbers(int number) {
        if (number == 1) {
            return 1;
        }

        return number + sumOfNNumbers(number - 1);
    }
}
