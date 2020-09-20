class NumMatrix {

    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length == 0 || matrix[0].length == 0) return;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i=1;i<n;i++) dp[0][i] = matrix[0][i] + dp[0][i-1];
        for(int i=1;i<m;i++) dp[i][0] = matrix[i][0] + dp[i-1][0];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1] + matrix[i][j];
            }
        }
        int ans = 0;
        for(int i=row1;i<=row2;i++){
            ans += dp[i][col2] - dp[i][col1] + matrix[i][col1];
        }
        return ans;
      }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
