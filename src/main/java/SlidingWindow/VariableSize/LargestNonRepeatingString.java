package SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Scanner;

public class LargestNonRepeatingString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.next();

        int largestNonRepeatingStrLength = largestNonRepeatingStr(str);
        System.out.println("Largest Non Repeating String is: " + largestNonRepeatingStrLength);
    }

    private static int largestNonRepeatingStr(String str) {
        HashMap<Character, Integer> nonRepeatingChar = new HashMap<>();
        int maxStringSize = Integer.MIN_VALUE;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char ch = str.charAt(windowEnd);
            if (!nonRepeatingChar.containsKey(ch)) {
                nonRepeatingChar.put(ch, 1);
            } else {
                if (maxStringSize < nonRepeatingChar.size())
                    maxStringSize = nonRepeatingChar.size();
                nonRepeatingChar.replace(ch, nonRepeatingChar.get(ch) + 1);

                char atStart = str.charAt(windowStart);
                nonRepeatingChar.replace(atStart, nonRepeatingChar.get(atStart) - 1);
                if (nonRepeatingChar.get(atStart) == 0) {
                    nonRepeatingChar.remove(atStart);
                }
                windowStart++;
            }
        }

        if (maxStringSize != Integer.MIN_VALUE)
            if (maxStringSize < nonRepeatingChar.size())
                return maxStringSize;
            else
                return maxStringSize;
        else {
            return nonRepeatingChar.size();
        }
    }
}
