class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        
        while(i >= 0 || j >= 0){
            int c1 = (i >= 0 ? num1.charAt(i--) - '0' : 0);
            int c2 = (j >= 0 ? num2.charAt(j--) - '0' : 0);
            int val = c1 + c2 + carry;
            sb.append(val % 10);
            carry = val/10;
        }
        
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
