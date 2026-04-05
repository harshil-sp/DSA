package BinarySearch.OnAnswers;

public class MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {

        MinimumNumberOfDaysToMakeMBouquets mBouquets = new MinimumNumberOfDaysToMakeMBouquets();
        int minDays = mBouquets.minDays(new int[]{}, 89945, 32127);
        System.out.println("Required Min Days is: " + minDays);

    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * (long) k > bloomDay.length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int days : bloomDay) {
            max = Math.max(max, days);
            min = Math.min(min, days);
        }

        int left = min, right = max;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isPossible = possible(bloomDay, mid, m, k);
            if (isPossible) {
                ans = Math.min(mid, ans);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;

    }

    private boolean possible(int[] blooms, int day, int m, int k) {

        int count = 0, noOfBuq = 0;

        for (int i = 0; i < blooms.length; i++) {
            if (blooms[i] <= day) {
                count++;
            } else {
                noOfBuq += count / k;
                count = 0;
            }
        }
        noOfBuq += count / k;

        if (noOfBuq >= m) {
            return true;
        } else {
            return false;
        }
    }

}
