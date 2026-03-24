package Patterns;

import java.util.Scanner;

/* pattern2
         *
       * *
     * * *
   * * * *
 * * * * *
 */

public class Pattern2 {
    public static void main(String[] args) {
        System.out.println("Enter number of lines: ");
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= n - i - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
