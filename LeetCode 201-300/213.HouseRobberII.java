class Solution {
    
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0] ; dp[1] = nums[0];
        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        int temp = dp[n-2];
        Arrays.fill(dp,0);
        dp[1] = nums[1]; dp[2] = nums[1];
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return Math.max(temp,dp[n-1]);
    }
                
}
