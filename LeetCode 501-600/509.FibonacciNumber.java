class Solution {
    public int fib(int N) {
        if(N <= 1)return N;
        if(N == 2)return 1;
        
        int first = 0;
        int second = 1;
        
        for(int i=2;i<=N;i++){
            int curr = first + second;
            first = second;
            second = curr;
        }
        return second;
    }
}
