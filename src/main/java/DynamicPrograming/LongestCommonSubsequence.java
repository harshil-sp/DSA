package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class LongestCommonSubsequence {
    private static InterfaceMaker Interface = new InterfaceMaker("DynamicPrograming//Inputs");

    private static int getSubSeqRec(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) {
            return 1+getSubSeqRec(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
        }
        return Math.max(getSubSeqRec(s1.substring(0,s1.length()-1),s2),getSubSeqRec(s1,s2.substring(0,s2.length()-1)));
    }

    private static String getString(int[][] table, String a, String b) {
        String str = "";
        int i = table.length-1;
        int j = table[0].length-1;
        while(i > 0 && j > 0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                str = a.charAt(i-1) + str;
                i --;
                j --;
            } else if(table[i-1][j] >= table[i][j-1]) {
                i --;
            } else {
                j --;
            }
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(Interface.getFile("LCS.txt"));
        int T = Integer.parseInt(scanner.readLine());
        while (T > 0) {
            String[] inputs = scanner.readLine().split(" ");
            int[][] table = new int[inputs[0].length()+1][inputs[1].length()+1];

            for (int i=1; i<table.length; i++) {
                for (int j=1; j<table[0].length; j++) {
                    if(inputs[0].charAt(i-1) == inputs[1].charAt(j-1)) {
                        table[i][j] = 1+table[i-1][j-1];
                    } else {
                        table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                    }
                }
            }

            for (int[] row : table) {
                System.out.println(Arrays.toString(row));
            }

            String str = getString(table, inputs[0], inputs[1]);
            System.out.println("String is : "+str);
            System.out.println("Longest Common Substring is of length (Using Tabulation) : "+table[table.length-1][table[0].length-1]);
            System.out.println("Longest Common Substring is of length : "+getSubSeqRec(inputs[0],inputs[1]));
            int mask = 0x000F;
            int value = 0x2222;
            System.out.println(value & mask);
            T --;
        }
    }
}
