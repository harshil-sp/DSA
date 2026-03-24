package Global;

import java.lang.reflect.Array;

public class ArrayPrinter {

    public static void printAnyArray(Object obj) {
        // 1. Handle null
        if (obj == null) {
            System.out.print("null");
            return;
        }

        // 2. Check if the object is essentially an Array
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            System.out.print("[");

            for (int i = 0; i < length; i++) {
                // 3. Recursive call: This handles multidimensional arrays automatically
                // Array.get(obj, i) retrieves the item even if it's a primitive (int, char, etc.)
                printAnyArray(Array.get(obj, i));

                if (i < length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        } else {
            // 4. Base case: It's not an array, just print the value
            System.out.print(obj);
        }
    }

    public static void main(String[] args) {
        // Test 1: 1D Primitive Array
        int[] arr1 = {1, 2, 3};
        printAnyArray(arr1);
        System.out.println();

        // Test 2: 2D Primitive Array
        int[][] arr2 = {{1, 2}, {3, 4}, {5, 6}};
        printAnyArray(arr2);
        System.out.println();

        // Test 3: 3D Mixed/Object Array
        Object[][][] arr3 = {
                {{"a", "b"}, {"c"}},
                {{"d", "e"}}
        };
        printAnyArray(arr3);
    }
}