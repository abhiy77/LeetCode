class Solution {
    public boolean isPalindrome(String s) {
        boolean flag = true;
        int i = 0, j = s.length() -1 ;
        while(i <= j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++; continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--; continue;
            }
            else{
                char a = s.substring(i,i+1).toLowerCase().charAt(0);
                char b = s.substrin g(j,j+1).toLowerCase().charAt(0);
                if(a != b){
                    flag = false;
                    break;
                }
                i++;j--;
            }
        }
        return flag;
    }
}
