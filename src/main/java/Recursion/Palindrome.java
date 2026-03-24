package Recursion;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string which you want to check for palindrome: ");
        String str = input.nextLine();

        if (isPalindrome(str))
            System.out.println("The string is palindrome.");
        else
            System.out.println("The string is not palindrome.");
    }

    private static boolean isPalindrome(String str) {
        // define base case
        if (str.length() == 0 || str.length() == 1)
            return true;

        // Do some work to shrink the problem space
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        // additional case to handle non-palindromes
        return false;
    }
}
