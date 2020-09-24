class WordDictionary {
public:
    
    struct TrieNode{
        TrieNode* next[26];
        bool isWord;
    };
    
    TrieNode* root;
    
    
    /** Initialize your data structure here. */
    WordDictionary() {
         root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    void addWord(string s) {
        TrieNode* temp = root;
        for(int i=0;i<s.size();i++){
            if(temp->next[s[i] - 'a'] == NULL){
                temp->next[s[i] - 'a'] = new TrieNode();
            }
            temp = temp->next[s[i] - 'a'];
        }
        temp->isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        return findWord(word,0,root);
    }
    
    bool findWord(string s,int idx,TrieNode* temp){
        if(idx == s.size()){
            return temp->isWord;
        }
        else if(s[idx] == '.'){
            for(int i=0;i<26;i++){
                if(temp->next[i] != NULL && findWord(s,idx+1,temp->next[i])){
                    return true;
                }
            }
        }
        else{
            if(temp->next[s[idx]-'a'] != NULL && findWord(s,idx+1,temp->next[s[idx] - 'a'])){
                return true;
            }            
        }
        return false;
    }
    
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
