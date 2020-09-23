class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[nums.length-1]) return nums[0];
        int low = 0,high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return nums[mid];
            else if(nums[mid] < nums[mid+1]){
                if(nums[mid] > nums[0]) low = mid+1;
                else high = mid-1;
            }
        }
        return nums[low];
    }
}
