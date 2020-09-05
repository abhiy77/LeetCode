class Solution {
    
        List<String> list = new ArrayList<>();
        Map <String,String> letters = new HashMap<String,String>(){{
           put("2","abc");
           put("3","def");
           put("4","ghi");
           put("5","jkl");
           put("6","mno");
           put("7","pqrs");
           put("8","tuv");
           put("9","wxyz");
        }};
        
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return list;
        else
            findCombinations("",digits);
        
        return list;
     }
    
    public void findCombinations(String com,String rem_digits){
        if(rem_digits.length() == 0){
            list.add(com);
        }
        else{
            String digit = rem_digits.substring(0,1);
            String get_letters = letters.get(digit);
            
            for(int i=0;i<get_letters.length();i++){
                String letter = get_letters.substring(i,i+1);
                findCombinations(com+letter,rem_digits.substring(1));
            }
        }
    }    
}
