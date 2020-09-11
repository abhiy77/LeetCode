class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        int MAX = 2000;
        int INC = 2001;
        int n = nums.size();
        if(n == 0) return false;
        
        for(int i=0;i<nums.size();i++){
            if(nums[i] > MAX) continue;
            bool isPositive = (nums[i] > 0);
            int j = i;
            
            while(true){
                if(nums[j] == INC) return true;
                if((isPositive && nums[j] < 0) || (!isPositive && nums[j] > 0))break;
                if(nums[j] > MAX) break;
                int jj = j;
                j = next(j,n,nums);
                
                if(jj == j) break;
                nums[jj] = INC;
            }
            INC++;
        }
        return false;
    }
    
    int next(int j,int n,vector<int> nums){
        return (j + nums[j]%n + n)%n;
    }
};
