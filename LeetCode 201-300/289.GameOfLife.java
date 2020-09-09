class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int neighbours = getNeighbours(board,i,j);
                
                if(board[i][j] == 1){
                    if(neighbours < 2 || neighbours > 3) board[i][j] = 2;
                    if(neighbours == 2 || neighbours == 3)board[i][j] = 1;
                }
                else{
                    if(neighbours == 3) board[i][j] = 3;
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    
    public int getNeighbours(int[][] board,int i,int j){
        int count = 0;
        int n = board.length;
        int m = board[0].length;
        if(i-1 >= 0 && (board[i-1][j] == 1 || board[i-1][j] == 2))count++;
        if(i-1 >= 0 && j+1 < m && (board[i-1][j+1] == 1 || board[i-1][j+1] == 2))count++;
        if(j+1 < m && (board[i][j+1] == 1 || board[i][j+1] == 2))count++;
        if(i+1 < n && j+1 < m  && (board[i+1][j+1] == 1 || board[i+1][j+1] == 2))count++;
        if(i+1 < n && (board[i+1][j] == 1 || board[i+1][j] == 2)) count++;
        if(i+1 < n && j-1 >= 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 2)) count++;
        if(j-1 >= 0 && (board[i][j-1] == 1 || board[i][j-1] == 2)) count++;
        if(i-1 >= 0 && j-1 >= 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 2)) count++;
        
        return count;
    }
}
