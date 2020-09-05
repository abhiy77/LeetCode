class Solution {
    
public:
    int lengthOfLongestSubstring(string s) {
       int n = s.length(),result = 0;
        unordered_map<char,int> map;
        
        for(int i=0,j=0;j<n;j++){
            if(map.find(s[j]) != map.end()){
                i = max(i,map[s[j]]);
            }
            result = max(result,j-i+1);
            map[s[j]] = j+1;
        }
        return result;
    }
};
