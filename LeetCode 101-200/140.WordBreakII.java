class Solution {
    
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<Character> set = new HashSet<>();
        result = new LinkedList<>();
        for(char c : s.toCharArray()){
            boolean found = false;
            if(set.contains(c)) continue;
            for(String str : wordDict){
                if(str.indexOf(c) != -1){
                    found = true;
                    break;
                }
            }
            if(!found) return result;
            set.add(c);
        }
        recurse(s,wordDict,new ArrayList<String>());
        return result;
    }
    
    public void recurse(String s,List<String> wordDict,List<String> temp){
        if(s.length() == 0){
            if(!result.contains(String.join(", ",temp))){
                result.add(String.join(" ",temp));
            }
        }
        for(String str : wordDict){
            if(s.startsWith(str)){
                temp.add(str);
                recurse(s.substring(str.length()),wordDict,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }   
}
