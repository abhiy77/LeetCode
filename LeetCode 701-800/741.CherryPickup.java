class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][] = new int[n][n][n];
        for(int[][] dp2 : dp){
            for(int[] dp3 : dp2){
                Arrays.fill(dp3,Integer.MIN_VALUE);
            }
        }
        return Math.max(0,findCherryCount(dp,grid,0,0,0));
    }
    
    public int findCherryCount(int[][][] dp,int[][] grid,int r1,int c1,int c2){
       int r2 = r1 + c1 - c2;
        int n = grid.length;
        
        if(r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return -1000000;
        }
        
        else if(r1 == n-1 && c1 == n-1) return grid[r1][c1];
        
        else if(dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];
        
        else{
            int ans = grid[r1][c1];
            if(c1 != c2) ans += grid[r2][c2];
            
            ans += Math.max(findCherryCount(dp,grid,r1+1,c1,c2),
                            Math.max(findCherryCount(dp,grid,r1+1,c1,c2+1),
                            Math.max(findCherryCount(dp,grid,r1,c1+1,c2),findCherryCount(dp,grid,r1,c1+1,c2+1))));
                            
            return dp[r1][c1][c2] = ans;
        }
    }
}
