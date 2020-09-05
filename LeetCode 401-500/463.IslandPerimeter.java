class Solution {
    int perimeter = 0;
    
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0)return 0;
        int n = grid.length;
        int m = grid[0].length;

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){          
                    check(i,j,grid);
                }
            }
        }
        return perimeter;
    }
    
    public void check(int i,int j,int[][] grid){
        if((i-1 >= 0 && grid[i-1][j] == 0) || i == 0)perimeter++;
        if((i+1 < grid.length && grid[i+1][j] == 0) || i == grid.length-1)perimeter++;
        if((j-1 >=0 && grid[i][j-1] == 0) || j == 0)perimeter++;
        if((j+1< grid[0].length && grid[i][j+1] == 0) || j == grid[0].length-1)perimeter++;
    }
}
