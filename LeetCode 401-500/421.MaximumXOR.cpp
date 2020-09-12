class Solution {
public:
    
    struct Trie{
        int val;
        Trie *nodes[2]={NULL};
    };
    
    
    int findMaximumXOR(vector<int>& nums) {
        Trie *root = new Trie();
        Trie *prev;
        
        for(int i=0;i<nums.size();i++){
            int num = nums[i];
            prev = root;
            for(int j=31;j>=0;j--){
                int digit = num & (1 << j);
                digit = digit != 0 ? 1 : 0;
                
                if(!prev->nodes[digit]){
                    prev->nodes[digit] = new Trie();
                }
                prev = prev->nodes[digit];
            }
            prev->val = nums[i];
        }
        
        int mx = 0;
        
        for(int i=0;i<nums.size();i++){
            int num = nums[i];
            prev = root;
            
            for(int j=31;j>=0;j--){
                int digit = num & (1 << j);
                digit = digit != 0 ? 0 : 1;
                
                if(prev->nodes[digit]) prev = prev->nodes[digit];
                else prev = prev->nodes[!digit];
            }
            mx = max(mx,prev->val ^ num);
        }
        return mx;
          
    }
};
