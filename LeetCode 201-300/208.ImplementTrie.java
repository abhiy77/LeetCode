class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.next(word.charAt(i)) == null){
                curr.trienodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.next(word.charAt(i));
        }
        curr.found = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.next(word.charAt(i)) == null ) return false;
            curr = curr.next(word.charAt(i));
        }
        return curr.found;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            if(curr.next(prefix.charAt(i)) == null ) return false;
            curr = curr.next(prefix.charAt(i));
        }
        return true;
    }
}

class TrieNode{
    TrieNode trienodes[] = new TrieNode[26];
    boolean found;
    TrieNode next(char c){
        return trienodes[c - 'a'];
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
