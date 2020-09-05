class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        String key = s1 + " " + s2;
        if(map.containsKey(key)) return map.get(key);
        if(s1.length() != s2.length())return false;
        if(s1.equals(s2))return true;
        if(s1.length() <= 1)return false;
        int n = s1.length();
        boolean flag = false;
        for(int i=1;i<=n-1;i++){
           boolean temp1  = isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,n),s2.substring(i,n)) ;
           boolean temp2 = isScramble(s1.substring(0,i),s2.substring(n-i,n)) && isScramble(s1.substring(i,n),s2.substring(0,n-i)) ;
                
           flag = temp1 || temp2;
           map.put(key,flag);
           if(flag)return flag;
        }
        return false;
    }
}
