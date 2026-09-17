class Solution {
    public int dominantIndex(int[] nums) {
        int max =-1;
        int Smax =-1;
        int maxIdx = 0;

        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                Smax = max;
                max = nums[i];
                maxIdx =i;
            }else if (Smax < nums[i]){
                Smax = nums[i];
            }
        }
        if(Smax*2 <= max){
            return maxIdx;
        }else{
            return -1;
        }

    }
}