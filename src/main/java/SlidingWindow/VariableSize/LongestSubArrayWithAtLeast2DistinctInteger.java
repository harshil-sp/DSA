package SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithAtLeast2DistinctInteger {
    public static void main(String[] args) {

        int totalElements = totalElements(new int[]{3, 3, 1, 3, 2, 2, 2, 1, 1, 2, 1, 3, 4});
        System.out.println(totalElements);

    }

    public static int totalElements(int[] arr) {
        // code here

        int maxLength = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> unqNum = new HashMap<>();

        while (right < arr.length) {
            unqNum.put(arr[right], unqNum.getOrDefault(arr[right], 0) + 1);

            while (unqNum.size() > 2) {
                unqNum.put(arr[left], unqNum.get(arr[left]) - 1);
                if (unqNum.get(arr[left]) == 0) {
                    unqNum.remove(arr[left]);
                }
                left++;
            }

            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
