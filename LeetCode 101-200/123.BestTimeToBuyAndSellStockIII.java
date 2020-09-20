class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        int transactions = 2;
        int dp[][] = new int[transactions+1][prices.length];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<prices.length;j++){
                for(int k=0;k<j;k++){        
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k] + prices[j] - prices[k]);
                }
                dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
            }
        }
        return dp[transactions][prices.length-1];
    }
}
