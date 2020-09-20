class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0) return 0;
        if(k > prices.length/2){
            int ans  = 0;
            for(int i=1;i<prices.length;i++){
                if(prices[i] > prices[i-1])ans+= prices[i]-prices[i-1];
            }
            return ans;
        }
        int dp[][] = new int[k+1][prices.length];
        for(int i = 1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                for(int q=0;q<j;q++){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][q] + (prices[j] - prices[q]));
                }
                dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
            }
        }
        return dp[k][prices.length-1];
    }
}
