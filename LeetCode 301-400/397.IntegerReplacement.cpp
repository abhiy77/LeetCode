class Solution {
public:
    int integerReplacement(int n) {
        queue<long long> queue;
        queue.push(n);
        
        unordered_set<long long> visited;
        visited.insert(n);
        for(int count = 0; !queue.empty();count++){
            for(int len = queue.size() ; len > 0 ;len--){
                auto val = queue.front();
                queue.pop();
                
                if(val == 1) return count;
                
                else if(val % 2 == 0){
                    insert(val/2,visited,queue);
                }
                else{
                    insert(val+1,visited,queue);
                    insert(val-1,visited,queue);
                }
            }
        }
        return -1;
    }
    
    void insert(long long val,unordered_set<long long>& visited,queue<long long>& queue){
        if(visited.count(val)) return;
        
        queue.push(val);
        visited.insert(val);
    }
};
