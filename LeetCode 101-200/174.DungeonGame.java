class Solution {
    
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        Integer dp[][] = new Integer[m][n];
        return findMinHealth(dp,0,0,dungeon);
    }
    
    public int findMinHealth(Integer[][] dp,int i,int j,int[][] a){
        if(i == dp.length -1 && j == dp[0].length -1){
            return a[i][j] > 0 ? 1 : -a[i][j] + 1;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(i == a.length - 1)
            return dp[i][j] = Math.max(1,findMinHealth(dp,i,j+1,a) - a[i][j]);
        else if(j == a[0].length - 1)
            return dp[i][j] = Math.max(1,findMinHealth(dp,i+1,j,a) - a[i][j]);
        return dp[i][j] = Math.max(1,Math.min(findMinHealth(dp,i+1,j,a),findMinHealth(dp,i,j+1,a)) - a[i][j]);
    }
    
}
