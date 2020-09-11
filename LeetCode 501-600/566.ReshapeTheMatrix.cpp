class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        vector<vector<int>> newMatrix;
        if(nums.size() == 0 || nums.size() * nums[0].size() != r * c) return nums;
        else{
            int cols = 0;
            vector<int> v;
            
            for(int i=0;i<nums.size();i++){
                for(int j=0;j<nums[0].size();j++){
                    if(cols == 0){
                        v.clear();
                    }
                    v.push_back(nums[i][j]);
                    cols++;
                    if(cols == c){
                        cols = 0;
                        vector<int> temp(v);
                        newMatrix.push_back(temp);
                    }
                }
            }
        }
        return newMatrix;
    }
};
