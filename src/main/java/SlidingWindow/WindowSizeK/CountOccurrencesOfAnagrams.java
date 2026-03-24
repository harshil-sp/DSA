package SlidingWindow.WindowSizeK;

/* Problem Statement
* Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
*
* An anagram of a word is a word that’s formed by rearranging the letters of the original word. For example: the
* anagrams of the word for are
* for
* fro
* ofr
* orf
* rfo
* rof
*
* Examples 1
* Input: text = forxxorfxdofr, word = for
* Output : 3
* Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
*
* Example 2
* Input : text = aabaabaa, word = aaba
* Output : 4
* Explanation : Anagrams of the word aaba - aaba, abaa each appear twice in the text and hence the count is 4.
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String word = input.next();

        int occurrencesOfAnagrams = countOccurrencesOfAnagrams(text, word);
        System.out.println("Number of anagrams is: " + occurrencesOfAnagrams);
    }

    private static int countOccurrencesOfAnagrams(String text, String word) {
        HashMap<Character, Integer> anagram = new HashMap<>();
        int numberOfOccurrencesOfAnagrams = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            anagram.put(ch, anagram.getOrDefault(ch, 0) + 1);
        }
        int count = anagram.size();

        int windowStart = 0;
        int k = word.length();
        for (int windowEnd = 0; windowEnd < text.length(); windowEnd++) {
            char temp = text.charAt(windowEnd);
            if (anagram.containsKey(temp)) {
                anagram.put(temp, anagram.getOrDefault(temp, 0) - 1);
                if (anagram.get(temp) == 0) {
                    count--;
                }
            }
            if (windowEnd - windowStart + 1 == k) {
                if (count == 0) {
                    numberOfOccurrencesOfAnagrams++;
                }
                char ch = text.charAt(windowStart);
                if (anagram.containsKey(ch)) {
                    anagram.put(ch, anagram.getOrDefault(ch, 0) + 1);
                    if (anagram.get(ch) != 0)
                        count++;
                }
                windowStart++;
            }
        }
        return numberOfOccurrencesOfAnagrams;
    }

    //    source: https://www.callicoder.com/count-occurrences-of-anagram/#problem-statement
//    Brute Force Technique
    // Two words are anagrams of each other if the count of every character in both the words are same.
    private static boolean isAnagram(Map<Character, Integer> word1CharCount, Map<Character, Integer> word2CharCount) {
        for(char c : word1CharCount.keySet()) {
            if(word1CharCount.get(c) != word2CharCount.get(c)) {
                return false;
            }
        }
        return true;
    }

    private static int countOccurrenceOfAnagram(String text, String word) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        // Calculate the count of each character for the given word
        Map<Character, Integer> wordCharCount = new HashMap<>();
        for(int i = 0; i < k; i++) {
            char c = word.charAt(i);
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0)+1);
        }

        for(int i = 0; i <= n-k; i++) {
            // Find the substring starting from i with length equal to the length of the word.
            // Calculate its char count to easily determine if it is an anagram of the word or not.
            Map<Character, Integer> substrCharCount = new HashMap<>();
            for(int j = i; j < i+k; j++) {
                char c = text.charAt(j);
                substrCharCount.put(c, substrCharCount.getOrDefault(c, 0)+1);
            }

            // Check if the current substring is an anagram of the given word
            if(isAnagram(wordCharCount, substrCharCount)) {
                count++;
            }
        }

        return count;
    }
}