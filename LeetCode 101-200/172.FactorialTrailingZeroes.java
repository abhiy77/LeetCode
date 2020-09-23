class Solution {
    public int trailingZeroes(int n) {
        int numFives = 0;
        
        while(n >= 5){
            numFives += Math.floor(n/5);
            n /= 5;
        }
        return numFives;
    }
}
