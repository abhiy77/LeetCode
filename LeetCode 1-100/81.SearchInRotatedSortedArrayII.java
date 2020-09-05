class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int i = 0;
        for(; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                break;
            }
        }
        int index = 0;
        if(nums[0] <= target && nums[i] >= target){
            index = Arrays.binarySearch(nums, 0, i + 1, target);
        }else{
            index = Arrays.binarySearch(nums, i + 1, nums.length, target);
        }
        if(index < 0){
            return false;
        }
        return true;
    }
}
