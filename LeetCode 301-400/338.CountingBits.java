class Solution {
    public int[] countBits(int num) {
        int result[] = new int[num+1];
        int i = 0;
        int val = (int)Math.pow(2,i);
        while(val <= num){
            result[val] = 1 ;
            i++;
            val = (int)Math.pow(2,i);
        }
        
        int lastOne = 2;
        for(int j=3;j<=num;j++){
            if(result[j] == 1){
                lastOne = j;
                continue;
            }
            else result[j] = result[j - lastOne] + 1;
        }
        return result;
    }
}
