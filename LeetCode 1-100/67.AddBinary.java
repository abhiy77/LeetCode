class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >=0 && j >=0){
            int sum = Integer.parseInt(""+a.charAt(i)) + Integer.parseInt(""+b.charAt(j))+ carry;
        
            if(sum == 0 || sum == 1){
                carry = 0;
                sb.append(""+sum);
            }
            else if(sum == 2){
                carry = 1;
                sb.append(0);
            }
            else if(sum == 3){
                carry = 1;
                sb.append(1);
            }
            i--;j--;
        }
        
        while(i >= 0){
            int sum =Integer.parseInt(""+a.charAt(i)) + carry;
            if(sum == 0 || sum == 1){
                sb.append(sum);
                carry = 0;
            }
            else if(sum == 2){
                carry = 1;
                sb.append(0);
            }
            i--;
        }
        while(j >= 0){
            int sum = Integer.parseInt(""+b.charAt(j)) + carry;
            if(sum == 0 || sum == 1){
                sb.append(""+sum);
                carry = 0;
            }
            else if(sum == 2){
                carry = 1;
                sb.append(0);
            }
            j--;
        }
        
        if(carry == 1){
            sb.append(""+1);
        }
        return sb.reverse().toString();
    }
}
