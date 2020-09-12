class Solution {
public:
    int bitwiseComplement(int num) {
        if(num == 0) return 1;
        
        string s;
        while(num != 0){
            if(num % 2 == 0) s+=to_string(1);
            else s+=to_string(0);
            num >>=1;
        }
        reverse(s.begin(),s.end());
        return stoi(s,0,2);
        
    }
};
