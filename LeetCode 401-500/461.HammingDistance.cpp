class Solution {
public:
    int hammingDistance(int x, int y) {
        int diffBits = 0;
        
        while(x > 0 || y > 0){
            diffBits += (x % 2 != y % 2) ? 1 : 0;
            x >>=1 ;
            y >>=1;
        }
        return diffBits;
    }
};
