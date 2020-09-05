import java.math.BigInteger;

class Solution {
    
    public String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int n1 = num1.length(),n2 = num2.length();
        char[] result = new char[n1+n2];
        Arrays.fill(result,'0');
        
        for(int j=n2-1;j>=0;j--){
            for(int i=n1-1;i>=0;i--){
                int product = ((arr1[i]-'0') * (arr2[j] - '0'));
                int temp = result[i+j+1] -'0'+ product;
                result[i+j+1] = (char)(temp%10 + '0');
                result[i+j] = (char)((result[i+j] - '0' + temp/10) + '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(char x : result){
            if(x == '0' && !found) continue;
            sb.append(x);
            found = true;
        }
        
        return (sb.length() == 0 ? "0" : sb.toString());
    }
}
