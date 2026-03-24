package BinomialCoefficient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binomial {
    // recursion approach...
    private static int computeNcR(int N, int R) {
        recCnt += 1;
        if(R==0 || N==R) {
            recCnt += 1;
            return 1;
        }

        recCnt += 2;
        return computeNcR(N-1,R-1)+computeNcR(N-1,R);
    }

    // memoization approach...
    private static int memoizedComputeNcR(int N, int R, int[][] tbl) {
        memoCnt += 1;
        if(R==0 || N==R) {
            tbl[N][R] = 1;
            return 1;
        }

        memoCnt += 1;
        if(tbl[N][R]!=0) {
            memoCnt += 1;
            return tbl[N][R];
        }

        return tbl[N][R] = memoizedComputeNcR(N-1,R-1, tbl)+memoizedComputeNcR(N-1,R,tbl);
    }

    private static int[][] tblMemo;
    private static int recCnt = 0;
    private static int memoCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(scan.readLine());

        while (T > 0) {
            // taking inputs, n and r
            String[] inp = scan.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int r = Integer.parseInt(inp[1]);
            tblMemo = new int[n+1][r+1];
            // initial table filling...for memoization...
            for(int i=0; i<tblMemo.length; i++) {
                for(int j=0; j<tblMemo[0].length; j++) {
                    if(j==0 || i==j) {
                        tblMemo[i][j] = 1;
                    }
                }
            }
            recCnt = 0;
            memoCnt = 0;

            System.out.println(n+"c"+r+" : "+computeNcR(n,r));
            System.out.println("Using Recursion Count is : "+recCnt);
            System.out.println(n+"c"+r+" : "+memoizedComputeNcR(n,r,tblMemo));
            System.out.println("Using Memoization Count is : "+memoCnt);
            T --;
        }
    }
}
