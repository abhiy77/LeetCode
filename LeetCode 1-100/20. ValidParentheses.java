class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()==0) return true;  // Base case
       
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
            }
            else if(stack.isEmpty()) return false;
            else if(map.containsKey(x)){
                char value = map.get(x);
                if(value != stack.peek()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
