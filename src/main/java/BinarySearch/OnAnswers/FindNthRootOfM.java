package BinarySearch.OnAnswers;

public class FindNthRootOfM {
    public static void main(String[] args) {

        int ans = new FindNthRootOfM().nthRoot(3, 27);
        System.out.println("nth root is " + ans);
    }

    public int nthRoot(int n, int m) {
        // code here
        int left = 0, right = m;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int midsNthPow = mid;

            for (int i = 1; i < n; i++) {
                midsNthPow *= mid;
            }

            if (midsNthPow == m) {
                return mid;
            } else if (midsNthPow > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
