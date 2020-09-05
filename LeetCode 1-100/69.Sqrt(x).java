class Solution {
    public int mySqrt(int x) {
        long left = 0,right = x,ans = 0;
        if(x == 0 || x == 1) return x;
        while(left < right){
            long num = (left + right)/2;
            if(num * num == x) return (int)num;
            if(num*num < x){
                ans = num;
                left = num+1;
            }
            else right = num;
        }
        return (int)ans;
    }
}
