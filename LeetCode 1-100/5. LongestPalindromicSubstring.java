class LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        if(s.length()< 1) return "";
        int begin=0,end=0;
        for(int i=0;i<s.length();i++){
            int l1 = findSubstring(s,i,i);
            int l2 = findSubstring(s,i,i+1);
            int maxlen = Math.max(l1,l2);
            if(maxlen > end - begin){
                begin = i - (maxlen-1)/2;
                end = i + maxlen/2;
            }
        }
        return s.substring(begin,end+1);
    }
 
    private int findSubstring(String s , int leftIndex,int rightIndex){
        int left = leftIndex , right = rightIndex;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
