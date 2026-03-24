package Recursion;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int number = input.nextInt();

        System.out.println("The Binary number of " + number + " is: " + decimalToBinary(number, ""));
    }

    private static String decimalToBinary(int decimal, String result) {
        if (decimal == 0)
            return result;

        result = decimal % 2 + result;
        return decimalToBinary(decimal / 2, result);
    }
}
