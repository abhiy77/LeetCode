class Solution {
	
    public void solveSudoku(char[][] board) {
        sudokuSolver(board);
        printBoard(board);
    }
    
    public static boolean isSafe(char[][] board,int i,int j,char value) {

		for(int q=0;q<9;q++) {
			if(board[i][q] == value || board[q][j] == value) {
				return false;
			}
		}

		for(int q = (i/3)*3;q< ((i/3)*3) +3 ;q++) {
			for(int w = (j/3)*3;w< ((j/3)*3) +3 ;w++) {
				if(board[q][w] == value) {
					return false;
				}
			}
		}
	return true;
}
    
    public boolean sudokuSolver(char[][] board){
        int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j] == '.') {
					row = i; col = j;
					isEmpty = false;
					break;
				}
			}
			if(isEmpty == false) break;
		}
		if(isEmpty == true) return true;
		
		for(int k = 1;k<10;k++) {
			if(isSafe(board,row,col,Integer.toString(k).charAt(0))) {
				board[row][col] = Integer.toString(k).charAt(0);
				if(sudokuSolver(board)) {
					return true;
				}
				else {
					board[row][col] ='.';
				}
			}	
		}
		return false;
    }
    
    
    public void printBoard(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
	
}
