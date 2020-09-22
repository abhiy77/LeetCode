class Solution {
      public void solve(char[][] board) {
          if(board.length == 0){
              return;
          }
          int m = board.length;
          int n = board[0].length;
          int[][] visited = new int[m][n];
          int[][] retain = new int[m][n];
          

          for(int i = 0;i<m;i++){
              for(int j = 0;j<n;j++){
                  char currChar = board[i][j];
                  if((i == 0 || j == 0 || i == m-1 || j == n-1 ) && currChar == 'O' ){
                      if(visited[i][j] != 1){
                          Queue<int[]> queue = new ArrayDeque<>();
                          queue.add(new int[]{i,j});
                          while(!queue.isEmpty()){
                              int[] curr = queue.poll();
                              int temp_x  = curr[0];
                              int temp_y = curr[1];
                              retain[temp_x][temp_y] = 1;
                              List<int[]> neighbours = getNeighbours(temp_x,temp_y,m,n);
                              for(int[] point : neighbours){
                                  if(board[point[0]][point[1]] == 'O' && visited[point[0]][point[1]] != 1){
                                      retain[point[0]][point[1]] = 1;
                                      visited[point[0]][point[1]] = 1;
                                      queue.add(point);
                                  }
                              }
                          }
                      }
                  }
              }
          }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(retain[i][j] != 1){
                    board[i][j] = 'X';
                }
                else {
                    toString();
                }
            }
        }
        
    }

    public List<int[]> getNeighbours(int x,int y,int m,int n){
        List<int[]> neighbous = new ArrayList<>();
        if(x-1 >= 0){
            neighbous.add(new int[]{x-1,y});
        }
        if(y-1>=0){
            neighbous.add(new int[]{x,y-1});
        }
        if(x+1 <= m-1){
            neighbous.add(new int[]{x+1,y});
        }
        if(y+1<=n-1){
            neighbous.add(new int[]{x,y+1});
        }
        return neighbous;
    }
}
