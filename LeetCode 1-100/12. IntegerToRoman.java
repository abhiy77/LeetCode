class Solution {
    public String intToRoman(int num) {
        
        if(num <=0 || num >3999) return null;
        
        String letters[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int numbers[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
         StringBuilder roman_num = new StringBuilder();
        for(int i =letters.length-1;i>=0;i--){
           
            while(num >= numbers[i]){
                num -= numbers[i];
                roman_num.append(letters[i]);
            }
            
        }
        return roman_num.toString();
    }
}
