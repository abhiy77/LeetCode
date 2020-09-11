class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerBed, int n) {
        if(n == 0)return true;
        int count = 0;
        int i = 0;
        int len = flowerBed.size();
        if(len== 0) return false;
        if(len == 1){
            if(n == 1 && flowerBed[0] == 0)return true;
            return false;
        }
        while(i < len){
            if(flowerBed[i] == 0){
                if(i == 0 && flowerBed[i+1] == 0){
                    count++;
                    flowerBed[i] = 1;
                    continue;
                }
                else if(i == len-1 && flowerBed[i-1] == 0){
                    count++;
                    flowerBed[i] = 1;
                }
                else if(i > 0 && i < len-1){
                    if(flowerBed[i-1] == 0 && flowerBed[i+1] == 0){
                        count++;
                        flowerBed[i] = 1;
                    }
                }
            }
            i++;
        if(count == n) return true;
        }

        return false;
    }
};
