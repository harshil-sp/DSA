package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knapsack01 {
    private static int bestRobbery() {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(scan.readLine());
        while (T > 0) {
            // taking inputs...
            String[] inp = scan.readLine().split(" ");
            int objectCnt = Integer.parseInt(inp[0]);
            int weightCap = Integer.parseInt(inp[1]);
            int[] weights = new int[objectCnt];
            int[] values = new int[objectCnt];

            String[] va_inp = scan.readLine().split(" ");
            String[] we_inp = scan.readLine().split(" ");
            for(int i=0; i<we_inp.length; i++) {
                weights[i] = Integer.parseInt(we_inp[i]);
                values[i] = Integer.parseInt(va_inp[i]);
            }
            // all inputs have been taken now...

            // made a table...
            int[][] tbl = new int[objectCnt][weightCap+1];

            // initial filling the table...
            for(int j=0; j<tbl[0].length; j++) {
                if(j >= weights[0]) {
                    tbl[0][j] = values[0];
                }
            }

            // computing result...
            for(int i=1; i<tbl.length; i++) {
                for(int j=1; j<tbl[0].length; j++) {
                    if(j<weights[i]) {
                        tbl[i][j] = tbl[i-1][j];
                    } else {
                        tbl[i][j] = Math.max(tbl[i-1][j],values[i]+tbl[i-1][j-weights[i]]);
                    }
                }
            }

            // displaying the result properly...
            System.out.println("If Weight Capacity="+weightCap+"\nWeights array : "+ Arrays.toString(weights)+"\nValues Array : "+ Arrays.toString(values)+"\nThen maxProfit = "+tbl[tbl.length-1][tbl[0].length-1]);
            // displaying the table......
            for(int[] r : tbl) {
                System.out.println(Arrays.toString(r));
            }
            System.out.println("=====================================================================================");
            T --;
        }
    }
}
