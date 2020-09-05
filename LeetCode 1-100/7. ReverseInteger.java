class Solution {
    public int reverse(int x) {
        int reverse_num = 0;
        while(x !=0){
            int y = x % 10;
            x /= 10;
            
if (reverse_num > Integer.MAX_VALUE/10 || (reverse_num == Integer.MAX_VALUE / 10 && y > 7))   {return 0;}
            
if (reverse_num < Integer.MIN_VALUE/10 || (reverse_num == Integer.MIN_VALUE / 10 && y < -8))  {return 0;}
            reverse_num = reverse_num * 10 + y;
        }
        return reverse_num;
    }
}
