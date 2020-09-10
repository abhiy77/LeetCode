class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> result;
        for(int i=0;i<nums.size();i++){
            int val = abs(nums[i]);
            if(nums[val - 1] < 0) result.push_back(val);
            else nums[val - 1] = -nums[val - 1];
        }

        return result;
    }
};
