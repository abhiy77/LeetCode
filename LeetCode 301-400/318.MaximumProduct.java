class Solution {
    public int maxProduct(String[] words) {
        
        if(words.length <= 1)return 0;
        int nums[] = new int[words.length];
        int idx = 0;
        
        for(String word : words){
            int temp = 0;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int num = c - 'a' + 1;
                temp |= 1 << num;
            }
            nums[idx++] = temp;
        }

        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i] & nums[j]) == 0){
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}
