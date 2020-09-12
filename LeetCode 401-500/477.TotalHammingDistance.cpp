class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        int dist = 0;
        
        for(int i=31;i>=0;i--){
            int ones = 0;
            int mask = 1 << i;
            for(int j=0;j<nums.size();j++){
                ones += ((nums[j] & mask) != 0 ? 1 : 0);
            }
            dist += (ones * (nums.size() - ones));
        }
        return dist;
    }
};
