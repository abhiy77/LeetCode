class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(high>0 && nums[high] == nums[high-1])
            high--;
        n = high;
        while(low<high){
            int mid = low + ((high-low)>>1);
            if(nums[mid]>=nums[n])
                low = mid+1;
            else
                high = mid;
        }
        return nums[low];        
    }
}
