class Solution {
public:
    bool validUtf8(vector<int>& data) {
        int num_bytes = 0;
        
        for(int i=0;i<data.size();i++){
            int num = data[i];
            
            if(num_bytes == 0){
                int mask = 1 << 7;
                
                while((mask & num) != 0){
                    num_bytes++;
                    mask >>= 1;
                }
                
                if(num_bytes == 0) continue;
                
                else if(num_bytes > 4 || num_bytes == 1) return false;
                
            }
            else{
                
                int mask1 = 1 << 7;
                int mask2 = 1 << 6;
                
                if( !((mask1 & num) != 0 && (mask2 & num) == 0))
                    return false;
                
            }
            num_bytes--;
        }
        return num_bytes == 0;
    }
};
