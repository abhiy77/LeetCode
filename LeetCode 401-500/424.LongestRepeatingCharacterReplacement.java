class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0)return 0;
        int start = 0;
        int arr[] = new int[26];
        int maxLen = 0;
        int maxCount = 0;
        
        for(int end=0;end<n;end++){
            
            char c = s.charAt(end);
            arr[c - 'A']++;
            maxCount = Math.max(maxCount, arr[c - 'A']);
            
            while(end - start - maxCount >= k){
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen,end - start + 1);
        }
        return maxLen;
    }
}
