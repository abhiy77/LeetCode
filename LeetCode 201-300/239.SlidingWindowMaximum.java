class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0 || k > nums.length) return new int[0];
        int n = nums.length;
        int res[] = new int[n-k+1];
        int max = Integer.MIN_VALUE;
        int index = -1;
        int left = 0,right = 0,idx = 0;
        while(right <= k-1){
            if(max <= nums[right]){
                max = nums[right];
                index = right;
            }
            right++;
        }
       
        res[idx++] = max;
        
        while(right < nums.length){
            left++;
            if(index < left){
                max = Integer.MIN_VALUE;
                for(int i=left;i<=right;i++){
                    if(nums[i] >= max){
                        max = nums[i];
                        index = i;
                    }
                }
            }
            else if(max <= nums[right]){
                max = nums[right];
                index = right;
            }
            
            res[idx++] = max;
            right++;
        }
        return res;
    }
}
