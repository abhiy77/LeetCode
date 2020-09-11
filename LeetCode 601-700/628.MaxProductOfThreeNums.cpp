class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        int min1 = INT_MAX , min2 = INT_MAX;
        int max1 = INT_MIN , max2 = INT_MIN , max3 = INT_MIN;
        
        for(int n : nums){
            if(n <= min1){
                min2 = min1;
                min1 = n;
            }
            else if(n <= min2){
                min2 = n;
            }
            if(max1 <= n){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if(max2 <= n){
                max3 = max2;
                max2 = n;
            }
            else if(max3 <= n){
                max3 = n;
            }
        }
        return max(max1 * max2 * max3 , max1 * min1 * min2);
    }
};