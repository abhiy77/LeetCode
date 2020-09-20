class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        for(int i = 1;i<=n;i++){
            int temp = 9;
            int digit = 9;
            int j = i-1;
            while(j > 0){
                temp = temp * digit;
                j--;
                digit--;
            }
            ans += temp;
        }
        return ans;
    }
}
