class Solution {
    
    public boolean isUpper(char c){
        if( c >= 'A' && c <= 'Z') return true;
        return false;
    }
    
     public boolean isLower(char c){
        if( c >= 'a' && c <= 'z') return true;
        return false;
    }
    
    public String countOfAtoms(String formula) {
        if(formula.length() == 0) return "";
        Stack<TreeMap<String,Integer>> stack = new Stack<>();
        stack.push(new TreeMap<String,Integer>());
        
        int i = 0;
        while(i < formula.length()){
            if(formula.charAt(i) == '('){
                stack.push(new TreeMap<>());
                i++;
            }
            else if(formula.charAt(i) == ')'){
                i++;
                if(i == formula.length())break;
                int j = 0;
                String s = "";
                while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                    s += formula.charAt(i++);
                }
                 TreeMap<String,Integer> tempMap = stack.pop();
                 if(tempMap.size() > 0){
                    int multiplier = s.equals("") ? 1 : Integer.parseInt(s);
                   
                    for(Map.Entry<String,Integer> entry : tempMap.entrySet()){
                        String key = entry.getKey();
                        int val = entry.getValue() * multiplier;
                        stack.peek().put(key,stack.peek().getOrDefault(key,0) + val);
                    }
                }
            }
            else if(isUpper(formula.charAt(i))){
                String s = ""+formula.charAt(i);
                i++;
                if(i == formula.length()){
                    stack.peek().put(s,stack.peek().getOrDefault(s,0)+1);
                    break;
                }
                while(i < formula.length() && isLower(formula.charAt(i))){
                    s += formula.charAt(i++);
                }
                String num = "";
                while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                    num += formula.charAt(i++);
                }
                TreeMap<String,Integer> map = stack.peek();
                map.put(s,map.getOrDefault(s,0) + (num.equals("") ? 1 : Integer.parseInt(num)));
            }        
        }
        
        while(stack.size() > 1){
            TreeMap<String,Integer> tempMap = stack.pop();
            TreeMap<String,Integer> map = stack.peek();
            
            for(Map.Entry<String,Integer> entry : tempMap.entrySet()){
                String key = entry.getKey();
                int val = entry.getValue();
                map.put(key,map.getOrDefault(key,0) + val);
            }
        }
        
        String result = "";
        TreeMap<String,Integer> map = stack.pop();
            
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            if(val == 1) result += key ;
            else result += (key+val);
        }
        return result;
    }

}
