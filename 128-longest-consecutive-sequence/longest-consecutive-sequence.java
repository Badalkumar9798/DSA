import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Boolean> hm = new HashMap<>();

        // Step 1: Store all elements
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], false);
        }

        // Step 2: Mark sequence starting elements
        for (int key : hm.keySet()) {
            if (hm.containsKey(key - 1) == false) {
                hm.put(key, true);
            }
        }

        int max = 0;

        // Step 3: Find longest sequence
        for (int key : hm.keySet()) {

            if (hm.get(key) == true) {

                int k = 1;

                while (hm.containsKey(key + k)) {
                    k++;
                }

                max = Math.max(max, k);
            }
        }

        return max;
    }
}