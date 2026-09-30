class Solution {
    public int maximumCount(int[] nums) {

        int negativeCount = firstNonNegative(nums);
        int positiveCount = nums.length - firstPositive(nums);

        return Math.max(negativeCount, positiveCount);
    }

    // First element >= 0
    public int firstNonNegative(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] >= 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    // First element > 0
    public int firstPositive(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}