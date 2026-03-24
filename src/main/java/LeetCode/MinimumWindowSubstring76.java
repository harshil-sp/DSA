package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {

        int n = s.length();

        // stores the count of each character in the current window
        HashMap<Character, Integer> windowCharMap = new HashMap<>();

        // stores the count of each character in the string t
        HashMap<Character, Integer> mapT = new HashMap<>();

        // length of the minimum window substring (the smallest substring of s that has all characters of t)
        int minWindowSubStrLength = Integer.MAX_VALUE;

        // start index of the minimum window substring
        int minWindowSubStrStart = 0;

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

//        windowCharMap.entrySet().contains(mapT.entrySet());

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // Add the next character of the string to the window
            char c = s.charAt(windowEnd);
            windowCharMap.put(c, windowCharMap.getOrDefault(c, 0) + 1);

            // Keep looking for a smaller window while the current window substring contains all the characters of t
            while (containsAll(windowCharMap, mapT)) {

                // current window length is less than previous window then change the length and set starting index to current window
                if (windowEnd - windowStart + 1 < minWindowSubStrLength) {
                    minWindowSubStrLength = windowEnd - windowStart + 1;
                    minWindowSubStrStart = windowStart;
                }

                // move the leftmost character out of the window
                char leftChar = s.charAt(windowStart);
                windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
                if (windowCharMap.get(leftChar) == 0) {
                    windowCharMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }

        }
        return s.substring(minWindowSubStrStart, minWindowSubStrStart + minWindowSubStrLength);
    }

    private static boolean containsAll(HashMap<Character, Integer> windowCharMap, HashMap<Character, Integer> mapT) {
        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (!windowCharMap.containsKey(c)) {
                return false;
            }

            if (windowCharMap.get(c) < count) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow2(String s, String t) {
        int n = s.length();

        // stores the starting index of current window string from string s
        int minimumWindowStartIndex = 0;

        // stores the length of minimum window
        int minimumWindowLength = Integer.MAX_VALUE;

        // stores the mapping of character from current window
        HashMap<Character, Integer> currWinCharMap = new HashMap<>();

        // stores the mapping of character from string t
        HashMap<Character, Integer> subStrMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            subStrMap.put(c, subStrMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char c = s.charAt(windowEnd);
            currWinCharMap.put(c, currWinCharMap.getOrDefault(c, 0) + 1);

            // keep looping until currWinCharMap contains subStrMap
            while (containsAll(currWinCharMap, subStrMap)) {

                // changing the length of minimum window
                if ((windowEnd - windowStart + 1) < minimumWindowLength) {
                    minimumWindowLength = windowEnd - windowStart + 1;
                    // changing the stating index of minimum string
                    minimumWindowStartIndex = windowStart;
                }

                // shrink the window
                char leftChar = s.charAt(windowStart);
                currWinCharMap.put(leftChar, currWinCharMap.get(leftChar) - 1);
                if (currWinCharMap.get(leftChar) == 0) {
                    currWinCharMap.remove(leftChar);
                }
                windowStart++;
            }
        }

        System.out.println(minimumWindowStartIndex + " " + minimumWindowLength);

        return s.substring(minimumWindowStartIndex, minimumWindowStartIndex + minimumWindowLength);
    }
}
