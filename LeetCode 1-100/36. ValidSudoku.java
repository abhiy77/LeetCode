class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == '.') continue;
                else {
                    if(! isSafe(i,j,board)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean isSafe(int row,int col,char[][] board){
        for(int i=0;i<9;i++){
            if(col == i ) continue;
            if(board[row][col] == board[row][i]) return false;
        }
        
        for(int i=0;i<9;i++){
            if(row == i ) continue;
            if(board[row][col] == board[i][col]) return false;
        }
        
        for(int i = (row/3)*3;i<(row/3)*3 + 3;i++){
            for(int j=(col/3)*3 ; j<(col/3)*3 + 3;j++){
                if(row == i && j == col) continue;
                if(board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }                      
}
