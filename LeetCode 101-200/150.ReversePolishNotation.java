class Solution {
    public int evalRPN(String[] tokens) {
       if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            char c = tokens[i].charAt(0);
            if(tokens[i].length() > 1 || Character.isDigit(c)){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                stack.push(useOperator(stack.pop(),stack.pop(),c));
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(char c){
            if(c == '+' || c == '-' || c == '*' || c == '/') return true;
            return false;
        }
        
    public int useOperator(int num1,int num2,char c){
        switch(c){
            case '+' : return num1 + num2;
            case '-' : return num2 - num1;
            case '*' : return num1 * num2;
            case '/' : return num2 / num1;
        }
        return 0;
    }
}
