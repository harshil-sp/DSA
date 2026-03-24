package Patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        System.out.println("Enter number of lines: ");
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if ((j >= n - i - 1 && j <= n + i - 1) && (i % 2 == j % 2))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
