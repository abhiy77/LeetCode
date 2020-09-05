class Solution {
    public int myAtoi(String str) {
        
        if(str.length() == 0) return 0;
        
        int pos = 0;
        while(pos < str.length() && str.charAt(pos) == ' '){
            pos+=1;
        }
        
        if(pos == str.length()) return 0;
        
        int x = Character.getNumericValue(str.charAt(pos));
        
        if((str.charAt(pos) != '+' && str.charAt(pos) != '-') && (x < 0 || x > 9 )){
            return 0;
        }
           
        int sign = 1;
        
        if(str.charAt(pos) == '-'){
            sign = -1;
            pos+=1;
        }
        else if(str.charAt(pos) == '+'){
            pos+=1;
        }
           
        long num = 0;
        while(pos < str.length()){
            x = Character.getNumericValue(str.charAt(pos));
            
            if(x < 0 || x > 9)
                return (int)num;
            
            num *= 10;
            
            if(sign == 1){
                num += x;
            }
            
            else{
                num -= x;
            }
            
            if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            pos+=1;
        }
        return (int) num;
    }
}
