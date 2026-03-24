package DivideAndConqure;

import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CountInversions {

    private static int[][] MergeCounts(int[] A, int m, int[] B, int n) {
        int i=0, j=0, k=0, count=0;
        int[] C = new int[m+n+1];
        while (k < m+n) {
            if (j==n || A[i]<=B[j]) {
                C[k] = A[i]; i++; k++;
            }

            if(i==m || A[i]>B[i]) {
                C[k] = B[j]; j++; k++;
                count += (m-i);
            }
        }
        return new int[][] {{count}, C};
    }

    public static int[][] MergeSortCount(int[] A, int l, int r) {
        int[] B = new int[A.length];
        int count = 0;
        if(r-l == 1) {
            B[0] = A[l];
            return new int[][] {{0}, B};
        }

        if (r-l > 1) {
            int mid = (l+r)/2;
            int[][] left = MergeSortCount(A,l,mid);
            int[][] right = MergeSortCount(A,mid,r);

            int[][] merged = MergeCounts(left[1], mid-l, right[1], r-mid);
            return new int[][] {{left[0][0]+right[0][0]+merged[0][0]}, B};
        }
        return new int[][] {{-1}};
    }

    public static void main(String[] args) throws IOException {
        InterfaceMaker ifm = new InterfaceMaker("DivideAndConqure\\Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("CountInversions.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T-- > 0) {
            int totalMovies = Integer.parseInt(scanner.readLine());
            String[] your_ratings = scanner.readLine().split(" ");
            String[] friend_ratings = scanner.readLine().split(" ");

            int[] rating_1 = new int[totalMovies];
            int[] rating_2 = new int[totalMovies];
            int[] mixed = new int[rating_1.length+ rating_2.length];
            for (int i=0; i<totalMovies; i++) {
                rating_1[i] = Integer.parseInt(your_ratings[i]);
                rating_2[i] = Integer.parseInt(friend_ratings[i]);
                mixed[i] = rating_1[i];
                mixed[rating_1.length+i] = rating_2[i];
            }

            System.out.println(Arrays.toString(mixed));
            int[][] ans = MergeSortCount(mixed,0, mixed.length);
            System.out.println("Inversions : "+ans[0][0]);

        }

    }
}
