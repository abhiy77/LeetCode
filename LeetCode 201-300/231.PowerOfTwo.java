class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        int temp = n;
        while(temp > 0){
            int bit = temp & 1;
            if(bit == 1) count++;
            temp >>= 1;
        }
        return count == 1;
    }
}
