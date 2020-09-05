class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        findCombinations(list,"",0,0,n);
        return list;
    }
    
    public void findCombinations(List<String> list, String current ,int open ,int close ,int max){
        if(current.length() == max*2){
            list.add(current);
            return;
        }
        
        if(open < max){
            findCombinations(list,current + "(",open+1,close,max);
        }
        if(close < open){
            findCombinations(list,current + ")",open,close+1,max);
        }
    }
}
