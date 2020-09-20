public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[1] > b[1]) return 1;
                else if(a[1] < b[1]) return -1;
                else if(a[1] == b[1]){
                    if(a[0] > b[0]) return 1;
                    else return -1;
                }
                return 0;
            }
        });
        
        int max = 1;
        int dp[] = new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i=1;i<envelopes.length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }             
}
