class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        for(int k=0;k<words.length;k++){
            String word = words[k];
            boolean visited[][] = new boolean[board.length][board[0].length];
            int flag = 0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(word.charAt(0) == board[i][j]){
                        visited[i][j] = true;
                        if(recurse(board,visited,i,j,word.substring(1))){
                            result.add(word);
                            flag = 1;
                            break;
                        }
                        visited[i][j] = false;
                     } 
                  }
                
            if(flag == 1) break;
           }
        }
        return result;
    }
    
    
    public boolean recurse(char[][] board,boolean visited[][],int i,int j,String s){
        if(s.isEmpty()) return true;
        if(i-1 >= 0 && s.charAt(0) == board[i-1][j] && !visited[i-1][j] ){
            visited[i-1][j] = true;
            if(recurse(board,visited,i-1,j,s.substring(1))) return true;
            visited[i-1][j] = false;
        }
        if(j+1< board[0].length && s.charAt(0) == board[i][j+1] && !visited[i][j+1] ){
            visited[i][j+1] = true;
            if(recurse(board,visited,i,j+1,s.substring(1))) return true;
            visited[i][j+1] = false;
        }
        if(i+1< board.length && s.charAt(0) == board[i+1][j] && !visited[i+1][j] ){
            visited[i+1][j] = true;
            if(recurse(board,visited,i+1,j,s.substring(1))) return true;
            visited[i+1][j] = false;
        }
        if(j-1>=0 && s.charAt(0) == board[i][j-1] && !visited[i][j-1] ){
            visited[i][j-1] = true;
            if(recurse(board,visited,i,j-1,s.substring(1))) return true;
            visited[i][j-1] = false;
        }
        return false;  
    }
    
    
}
