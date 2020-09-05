class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        recurse(result,new LinkedList<String>(),s);
        return result;
    }
    
    public void recurse(List<List<String>> result,List<String> list,String s){
        if(s.equals("")){
            result.add(new LinkedList<>(list));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp = s.substring(0,i);
            if(map.containsKey(temp) || isPalindrome(temp)){
                list.add(temp);
                map.put(temp,true);
                recurse(result,list,s.substring(i));
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
