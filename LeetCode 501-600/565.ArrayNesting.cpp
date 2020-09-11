class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        int n = nums.size();
        int INF = INT_MAX;
        int maxi = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] != INF){
                int count = 0;
                int start = nums[i];
                
                while(nums[start] != INF){
                    int temp = start;
                    start = nums[start];
                    nums[temp] = INF;
                    count++;
                }
                
                maxi = max(maxi,count);
            }
        }
        return maxi;
    }
};
