package SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubStringWithNoCharRepeating {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = sca.next();

        int largestNonRepeatingStr = largestNonRepeatingStrSlidingWindow(input);
        System.out.println("Largest substring length with non repeating char: " + largestNonRepeatingStr);
    }

    private static int largestNonRepeatingStrSlidingWindow(String str) {

        int left = 0, right = 0;
        int maxLength = 0;

        Map<Character, Integer> charIndexMap = new HashMap<>();

        while(right < str.length()) {
            char currentChar = str.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                if (charIndexMap.get(currentChar) < left) {
                    charIndexMap.put(currentChar, right);
                    int length = right - left + 1;
                    maxLength = Math.max(maxLength, length);
                } else {
                    left = charIndexMap.get(currentChar) + 1;
                    charIndexMap.put(currentChar, right);
                }
                right++;
            } else {
                charIndexMap.put(currentChar, right);
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
                right++;
            }
        }

        return maxLength;
    }

    private static int largestNonRepeatingStrBruteForce(String str) {

        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            int[] ascii = new int[255];

            for (int j = i; j < str.length(); j++) {
                if (ascii[str.charAt(j)] == 1)
                    break;
                ascii[str.charAt(j)] = 1;
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
