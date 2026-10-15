class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Fixed: Changed from k% = n to k %= n

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    // Fixed: Corrected 'rigth' to 'right' in parameters
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp; // Fixed: Changed from nums[rigth] to nums[right]
            left++;
            right--;
        }
    }
}
