class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1) return Collections.min(triangle.get(0));
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE; 
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0) dp[i][0] = triangle.get(i).get(j) + dp[i-1][0];
                else if(j == i) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                if(i==n-1) min = Math.min(min,dp[i][j]);
             }
        }
        System.out.println(Arrays.deepToString(dp));
        return min;
    }
}
