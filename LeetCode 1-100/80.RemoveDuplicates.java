class Solution {
    
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 ) return 0;
        int repeat = 1;
        int num = nums[0];
        int moveTo = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == num && repeat < 2){
                nums[moveTo] = nums[i];
                moveTo++;
                repeat++;
            }
            else if(nums[i] == num && repeat == 2){
                continue;
            }
            else if(nums[i] != num){
                nums[moveTo] = nums[i];
                num = nums[i];
                moveTo++;
                repeat = 1;
            }
        }
        return moveTo;
    }
}
