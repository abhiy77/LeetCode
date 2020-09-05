class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) 
            return (dividend == Integer.MIN_VALUE)? 1 : 0;
        return (int)Math.floor(dividend/divisor);
    }
}
