class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        int n = nums.size();
        if(n < 3) return 0;
        int count = 0;
        sort(nums.begin(),nums.end());
        
        for(int i=0;i<n-2;i++){
            if(nums[i] == 0)continue;
            int k = i+2;
            
            for(int j=i+1;j<n-1;j++){
                while(k < nums.size() && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                count += k-j-1;
            }
        }
        return count;
    }
};
