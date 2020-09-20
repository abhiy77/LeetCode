class Solution {
    public int integerBreak(int n) {
        int ans[] = {0,1,1,2,4};
        if(n <= 4) return ans[n];
        switch(n % 3){
            case 0:
                return (int)Math.pow(3,n/3);
            case 1:
                return 4 * (int)Math.pow(3,(n-4)/3);
            case 2:
                return 2 * (int)Math.pow(3,(n-2)/3);
        }
        return 0;
    }
}
