class Solution {
public:
    
    vector<int> twoSum(vector<int>& nums, int target) {
             vector<int> v;
             unordered_map<int,int> map;
        for(int i=0;i<nums.size();i++){
            if(map.find(nums[i]) == map.end()){
                map[nums[i]] = 1;
            }
            else{
                map[nums[i]] = map[nums[i]] + 1;
            }
        }
        for(int i=0;i<nums.size();i++){
            if(map.find(target - nums[i]) !=map.end() ){
                vector<int>::iterator it;
                it = find (nums.begin()+i+1, nums.end(), target-nums[i]); 
                if(it == nums.end()){continue;}
                v.push_back(i);  v.push_back(it- nums.begin());
                break;
            }
        }
    return v;
    }
};
