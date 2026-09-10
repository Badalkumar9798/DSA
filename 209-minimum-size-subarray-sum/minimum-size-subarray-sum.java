class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // Define pointers
        int L = 0, R = 0;

        // Minimum length and current sum
        int min = Integer.MAX_VALUE;
        int sum = 0;

        int n = nums.length;

        // Sliding window
        while (R < n) {

            // Add current element
            sum += nums[R];

            // Contract window
            while (target <= sum) {
                min = Math.min(min, R - L + 1);
                sum -= nums[L];
                L++;
            }

            R++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}