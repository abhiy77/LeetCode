class Solution {
    public int totalNQueens(int n) {
        List<List<String>> list = new LinkedList<>();
         boolean[][] visited = new boolean[n][n]; 
        List<StringBuffer> temp = new LinkedList<>();
        for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            temp.add(sb);
        }
        recurse(n,list,0,visited,temp);
        return list.size();
    }
    
    public static void recurse(int n,List<List<String>> list,int j,boolean[][] visited,List<StringBuffer> temp)
    {
        if(j == n){
            List<String> out = new LinkedList<>();
            for(int i=0;i<temp.size();i++){
                out.add(temp.get(i).toString());
            }
            list.add(out);
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,j,visited,n)){
                visited[i][j] = true;
                temp.get(i).setCharAt(j,'Q');
                recurse(n,list,j+1,visited,temp);
                temp.get(i).setCharAt(j,'.');
                visited[i][j] = false;
            }
        }
    }
    
     public static boolean isSafe(int i,int j,boolean[][] visited,int n){
    	int x = i-1,y=j-1;
    	while(x>=0 && y >=0) {
    		if(visited[x][y]) return false;
    		x--; y--;
    	}
    	x=i+1;y=j-1;
    	while(x<n && y>=0) {
    		if(visited[x][y]) return false;
    		x++; y--;
    	}
        for( x=0;x<j;x++){
            if(visited[i][x]) return false;
        }
        return true;
    }
}
