package DynamicPrograming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MakingChange {
    private static final String InputFileDirectory = "D:\\Project\\Analysis-DAA\\src\\DynamicProg\\";

    private static int helperRec(int[] coins, int index, int amount, int picked) {
        if(index < 0) {
            if(amount == 0) {
                return picked;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int WhenPicked = Integer.MAX_VALUE;
        if(amount > 0) {
            WhenPicked =  helperRec(coins, index, amount-coins[index], picked+1);
        }
        int WhenNotPicked = helperRec(coins, index-1, amount, picked);
        return Math.min(WhenPicked, WhenNotPicked);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new FileReader(InputFileDirectory+"Inputs\\MakingChange.txt"));
        int T = Integer.parseInt(scanner.readLine());
        while (T > 0) {
            // first line of this test case...
            String[] inp = scanner.readLine().split(" ");
            int coins = Integer.parseInt(inp[0]);
            int amount = Integer.parseInt(inp[1]);

            // second line of this test case...
            String[] str_coins = scanner.readLine().split(" ");
            int[] coinValues = new int[coins];
            for(int i=0; i<coins; i++) {
                coinValues[i] = Integer.parseInt(str_coins[i]);
            }

            long timea = System.nanoTime();
            int[][] table = new int[coins+1][amount+1];
            for(int i=0; i<amount+1; i++) {
                table[0][i] = Integer.MAX_VALUE;
            }
            for(int i=0; i<coins+1; i++) {
                table[i][0] = 0;
            }

            for (int i=1; i<coins+1; i++) {
                for (int j=1; j<amount+1; j++) {
                    if(j >= coinValues[i-1]) {
                        table[i][j] = Math.min(table[i-1][j], ((table[i][j-coinValues[i-1]] == Integer.MAX_VALUE)?0:1)+table[i][j-coinValues[i-1]]);
                    } else {
                        table[i][j] = table[i-1][j];
                    }
                }
            }
            long timeb = System.nanoTime();

            System.out.println("From Tabulation : "+table[table.length-1][table[0].length-1]+" TIME : "+Math.abs(timeb-timea));
            for(int[] row : table) {
                System.out.println(Arrays.toString(row));
            }
            timea = System.nanoTime();
            int result = helperRec(coinValues, coins-1, amount, 0);
            timeb = System.nanoTime();
            System.out.println("From Recursion : "+result+" TIME : "+Math.abs(timeb-timea));
            System.out.println("=====================================================================================");

            T -= 1;
        }
    }
}
