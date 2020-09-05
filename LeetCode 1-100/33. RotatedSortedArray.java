class Solution {
    
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int i = 0,j=nums.length-1;
        if(nums.length == 1){
            if(target == nums[0]) return 0;
            else return -1;
        }
        int save = 0;
        while(i < j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[0] && nums[mid+1] < nums[mid]){
                save = mid;
                break;
            }
            else if(nums[mid] >= nums[0] && nums[mid+1] > nums[mid]){
                save = mid+1;
                i = mid+1; continue;
            }
            else if(nums[mid] < nums[0]){
                save = mid-1;
                j = mid-1; continue;
            }    
        }
        if(target >= nums[0] && target <= nums[save]){
            int x = Arrays.binarySearch(nums,0,save+1,target);
            if(x >=0) return x;
            else return -1;
           
        }
        else{
            int x = Arrays.binarySearch(nums,save+1,nums.length,target);
            if(x >= 0) return x;
            else return -1;
        }
    }
}
