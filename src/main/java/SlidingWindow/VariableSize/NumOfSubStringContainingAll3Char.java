package SlidingWindow.VariableSize;

import java.util.Scanner;

public class NumOfSubStringContainingAll3Char {

    public static void main(String[] args) {

        NumOfSubStringContainingAll3Char solution = new NumOfSubStringContainingAll3Char();
        System.out.println("Enter a String: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int result = solution.numberOfSubstrings(input);
        System.out.println("Number of SubString containing all 3 char is: " + result);
    }

    public int numberOfSubstrings(String s) {
        int count  = 0;
        int n = s.length();

        for (int  i = 0 ; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subString = s.substring(i, j + 1);
                if (subString.contains("a") && subString.contains("b") && subString.contains("c")) {
                    count++;
                }
            }
        }

        return count;
    }
}
