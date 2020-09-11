class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        int n = nums.size();
        if(k < 0) return 0;
        map<int,int> m;
        int pairs = 0;
        
        for(int i=0;i<n;i++){
            if(m.count(nums[i]) == 0){
                if(m.count(nums[i] - k)) pairs++;
                if(m.count(nums[i] + k)) pairs++;
            }
            if(k == 0){
                if(m.count(nums[i]) && m[nums[i]] == 1) pairs++;
            }
            m[nums[i]]++;
        }
        return pairs;
    }
};
