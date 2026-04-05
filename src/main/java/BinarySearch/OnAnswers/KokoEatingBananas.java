package BinarySearch.OnAnswers;

public class KokoEatingBananas {
    public static void main(String[] args) {

        int ans = new KokoEatingBananas().minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000);
        System.out.println("Minimum Speed is: " + ans);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int num : piles) {
            if (num > max) {
                max = num;
            }
        }

        int left = 1, right = max;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long reqTime = 0;
            for (int num : piles) {
                reqTime += (int) Math.ceil((double) num / mid);
            }
            if (reqTime <= h) {
                if (ans > mid) {
                    ans = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
