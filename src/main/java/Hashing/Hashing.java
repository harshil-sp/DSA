package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hashArray = new int[20];
        Arrays.fill(hashArray, -1);

        for (int i = 0; i < 15; i++) {
            System.out.print("Enter a number: ");
            int temp = Integer.parseInt(br.readLine());
            int reminder = hash(temp);
            if (hashArray[reminder] == -1)
                hashArray[reminder] = temp;
            else {
                boolean flag = true;
                for (int j = reminder + 1; j < hashArray.length; j++) {
                    if (hashArray[j] == -1) {
                        hashArray[j] = temp;
                        flag = false;
                        break;
                    }
                }
                for (int k = 0; k < reminder && flag; k++) {
                    if (hashArray[k] == -1) {
                        hashArray[k] = temp;
                        break;
                    }
                }
            }
        }

        System.out.print("[ ");
        for (int i = 0; i < hashArray.length; i++) {
            System.out.print(i + " : " + hashArray[i] + " , ");
        }
        System.out.println(" ]");
    }

    public static int hash(int number) {
        return (number % 18) + 2;
    }
}
