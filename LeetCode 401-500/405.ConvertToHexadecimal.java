class Solution {
    private char[] hexDigits = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b',
                                          'c','d','e','f'};
        
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            char digit = hexDigits[15 & num];
            sb.append(digit);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
