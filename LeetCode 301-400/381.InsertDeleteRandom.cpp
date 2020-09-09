class RandomizedCollection {
public:
    unordered_map<int,unordered_set<int>> m;
    vector<int> v;
    /** Initialize your data structure here. */
    RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    bool insert(int val) {
        bool ans=m.count(val);
        v.push_back(val);
        m[val].insert(v.size()-1);
        return 1-ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    bool remove(int val) {
        bool ans=m.count(val);
        if(!ans)return false;
        int idx=*(m[val].begin());
        m[val].erase(m[val].begin());
        
        int temp=v.back();
        v[idx]=temp;
        m[temp].insert(idx);
        m[temp].erase(v.size()-1); 
        v.pop_back();
        
        if(m[val].size()==0)m.erase(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    int getRandom() {
        return v[rand()%v.size()];
    }
};
