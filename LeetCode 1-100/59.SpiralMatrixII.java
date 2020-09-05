class Solution {
    
    public int[][] generateMatrix(int n) {
        int count = 1;
        int arr[][] = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        
        while(r1 <= r2 && c1 <= c2){
            for(int i=c1;i<=c2;i++)arr[r1][i] = count++;
            for(int i=r1+1;i<=r2;i++)arr[i][c2] = count++;
            
            if(r1 < r2 && c1 < c2){
                for(int i=c2-1;i>=c1;i--)arr[r2][i] = count++;
                for(int i=r2-1;i>r1;i--)arr[i][c1] = count++;
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return arr;
    }
}
