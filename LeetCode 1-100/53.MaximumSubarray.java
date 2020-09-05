class Solution {
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE,cum = 0;
        for(int i=0;i<nums.length;i++){
            cum += nums[i];
            if(max < cum) max = cum;
            if(cum < 0) cum = 0;

        }
        return max;
    }
}
