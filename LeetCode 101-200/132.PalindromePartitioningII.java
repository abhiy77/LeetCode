class Solution {

    public int minCut(String s) {
        boolean[][] ispal= new boolean[s.length()+1][s.length()+1];
        int [] re = new int[s.length()+1];
        for( int i =0 ; i< s.length() ; i ++)
        {
            ispal[i][i]=true;
            ispal[i][i+1]=true;
        }
        for( int gap = 2 ; gap <=s.length(); gap++)
        {
            for( int i = 0 ; i + gap <= s.length(); i++){
                if( s.charAt(i) == s.charAt(i+gap -1))
                {
                    if( i+1 > i+gap-2)
                        ispal[i][i+gap]=true;
                    else if( ispal[i+1][i+gap-1] ==true)
                    {
                        ispal[i][i+gap]=true;
                    }
                }
            }
        }
        for( int i = 0 ; i <= s.length(); i++)
            re[i]=i-1;
       
        for( int i =1 ; i <= s.length(); i++)
        {
            for( int j =0 ; j < i; j++){
                if ( ispal[j][i]){
                    re[i]=Math.min(re[i],re[j]+1);
                }
            }
        }
        return re[s.length()]; 
    }
}
