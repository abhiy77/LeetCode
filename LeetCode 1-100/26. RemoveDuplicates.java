class Solution {
    
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                int j = i;
                while(j < nums.length && nums[j] == nums[j-1]){
                    j++;
                }
                if(j == nums.length) return k;
                else nums[k++] = nums[j];
                i=j; 
            }
            else if(nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            } 

        }
        return k;
    }
}
