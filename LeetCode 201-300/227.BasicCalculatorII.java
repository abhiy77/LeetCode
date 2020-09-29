class Solution {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int operand = 0;
        int n = 0;
        
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                 while(i >= 0 && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')){
                     c = s.charAt(i);
                     if(c == ' '){
                        i--;
                     }
                     else{
                            operand += Math.pow(10,n) * (c - '0');
                            n++;
                            i--;
                     }
                 }
                i++;
                operands.push(operand);
                operand = 0;
                n=0;
            }
            else if(c == ' ')continue;
            else if(prec(c) == 2){
                ops.push(c);
            }
            else if(prec(c) == 1){
                while(!ops.isEmpty() && prec(c) < prec(ops.peek())){
                    char x = ops.pop();
                    int a = operands.pop();
                    int b = operands.pop();
                    int res = val(a,b,x);
                    operands.push(res);
                }
                ops.push(c);
            }
        }
        while(!ops.isEmpty()){
            char x = ops.pop();
            int a = operands.pop();
            int b = operands.pop();
            int res = val(a,b,x);
            operands.push(res);
        }
        return operands.pop();
    }
             
    public int prec(char c){
        if(c == '*' || c == '/'){
            return 2;  
        }
        else return 1;
    }
    
    public int val(int a,int b,char c){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else if(c == '*') return a * b;
        else return a/b;
    }
}
