package Recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string which you want to reverse: ");
        String str = input.nextLine();

        System.out.println("Reverse string is: " + reverseString(str));
    }

    private static String reverseString(String str) {
        if (str.equals(""))
            return "";

        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
