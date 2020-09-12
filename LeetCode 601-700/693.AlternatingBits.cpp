class Solution {
public:
    bool hasAlternatingBits(int num) {
        int alt = -1;
        while(num > 0){
            if(alt == -1){
                alt = num % 2 == 0 ? 0 : 1;
            }
            else{
                int digit = num % 2 == 0 ? 0 : 1;
                if((alt ^ digit) == 0)return false;
                else alt = digit;
            }
            num >>= 1;
        }
        return true;
    }
};
