class Solution {
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        int dp[][] = new int[n][n];
        for(int len=0;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j = i+len;
                for(int k=i;k<=j;k++){
                    int leftNum = (i==0 ? 1 : nums[i-1]);
                    int rightNum = (j == n-1 ? 1 :nums[j+1]);
                    
                    int leftRec = (k == i? 0 : dp[i][k-1]);
                    int rightRec = (k == j?0:dp[k+1][j]);
                    dp[i][j] = Math.max(dp[i][j],leftNum*nums[k]*rightNum+leftRec+rightRec);
                }
            }
        }
        return dp[0][n-1];
    }
}
