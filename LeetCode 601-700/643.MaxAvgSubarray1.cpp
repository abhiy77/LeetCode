class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        
        double sum = 0;
        int i=0,j=0;
        while(j < k){
            sum += nums[j++];
        }

        double aveg = sum/k;
        
        while(j < nums.size()){
            sum -= nums[i++];
            sum += nums[j++];
            double temp = sum/k;
            if(aveg < temp)aveg = temp;
        }
        return aveg;
    }
};
