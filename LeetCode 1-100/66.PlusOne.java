class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1 == 10 ){
                digits[i]=0;
                if(i == 0){
                   int temp[] = new int[digits.length+1];
                   temp[0] = 1;
                   for(int j=0;j<digits.length;j++)
                        temp[j+1] = digits[j];
                    return temp;
                }
            }
            else if(digits[i]+1 != 10){
                digits[i]+=1;
                return digits;
            } 
        }
        return digits;
    }
}
