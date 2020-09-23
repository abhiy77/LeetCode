class Solution {
    public int titleToNumber(String s) {
        int ans = 0,power = 1;
        for(int i=s.length()-1;i>=0;i--){
            ans += ((int)(s.charAt(i) - 'A') + 1) * power;
            power *= 26;
        }
        return ans;
    }
}
