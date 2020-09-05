class Solution {
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        boolean visited[][] = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid,i,j,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void bfs(char[][] grid,int i,int j,boolean visited[][]){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int arr[] = queue.poll();

            int directions[][] = {{0,1},{1,0},{-1,0},{0,-1}};
            for(int k=0;k<directions.length;k++){
                int x = arr[0] + directions[k][0];
                int y = arr[1] + directions[k][1];

                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)continue;
                if(grid[x][y] == '1' && !visited[x][y]){
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }    
    }
}
