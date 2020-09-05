class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x!=0 && x%10 == 0) return false;
        
        int half_num = 0;
        
        while(x > half_num){
            half_num = half_num*10 + x%10;
            x /=10;    
        }
        return x == half_num || x == half_num/10; 
    }
}
