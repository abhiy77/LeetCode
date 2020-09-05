class Solution {
    
    public int longestOnes(int[] A, int k) {
        int n = A.length;
        if(n == 0)return 0;
        int start = 0;
        int maxLength = 0;
        int zeros = 0;
        
        
        for(int end=0;end<n;end++){
            if(A[end] == 0) zeros++;
            
            while(zeros > k){
                if(A[start] == 0) zeros--;
                start++;
            }
            
            maxLength = Math.max(maxLength,end - start + 1);
        }
        return maxLength;
    }
}
