class Solution {
public:
    
    static bool compare(string num1,string num2){
        string a = num1 + num2;
        string b = num2 + num1;
        
        return a > b;
    }
    
    string largestNumber(vector<int>& nums) {
        
        vector<string> vec;
        for(int i=0;i<nums.size();i++){
            vec.push_back(to_string(nums[i]));
        }
        
        
        string s;
        int n = nums.size();
        sort(vec.begin(),vec.end(),compare);
        if(vec[0] == "0") return "0";
        for(int i=0;i<vec.size();i++){
            s += vec[i];
        }
        return s;
    }
};
