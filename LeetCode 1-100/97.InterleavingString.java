class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char str1[] = s1.toCharArray();
         char str2[] = s2.toCharArray();
         char str3[] = s3.toCharArray();
        
        
        boolean dp[][] = new boolean[str1.length +1][str2.length +1];
        
        if(str1.length + str2.length != str3.length){
            return false;
        }
        
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        dp[i][j] = dp[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = (str1[i-1] == str3[l] ? dp[i-1][j] : false) || (str2[j-1] == str3[l] ? dp[i][j-1] : false);
                }
            }
        }
        return dp[str1.length][str2.length];
    }
}
