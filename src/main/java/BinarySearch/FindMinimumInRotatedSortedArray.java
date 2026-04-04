package BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] input = new int[] {43, 44, 45, 46, 47, 49, 50, 51, 53, 54, 56, 57, 58, 59, 60, 64, 67, 69, 75, 94, 4, 15, 17, 19, 20, 21, 22, 25, 26, 28, 31, 32, 33, 34, 35, 36, 37, 38, 39, 41, 42};

        FindMinimumInRotatedSortedArray findMin = new FindMinimumInRotatedSortedArray();
        int min = findMin.findMin(input);
        System.out.println(min);

    }

    public int findMin(int[] nums) {
        int mid = (nums.length - 1) / 2;
        return nums[binarySearch(nums, 0, nums.length - 1, mid)];
    }

    private int binarySearch(int[] nums, int left, int right, int mid) {

        if (left > right) {
            return left;
        }

        if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
            return binarySearch(nums, mid + 1, right, mid + 1 + (right - mid - 1)/2);
        } else {
            return binarySearch(nums, left, mid - 1, left + (mid - 1 - left)/2);
        }
    }
}
