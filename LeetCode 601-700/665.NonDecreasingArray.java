class Solution {
    public boolean checkPossibility(int[] nums) {
        int change = 1;
        int idx = 0;
        if(nums.length <= 2)return true;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                if(change == 1){
                    change--;
                    idx = i;
                }
                else return false;
            }
        }
        return (idx == 0 || change == 1 || idx == nums.length - 2 || nums[idx-1] <= nums[idx+1] ||                      nums[idx] <= nums[idx+2]);
    }
}
