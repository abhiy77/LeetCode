class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        if(nums.length < 3) return -1;
        int closest = Integer.MAX_VALUE;
        int save_state = 0;
        Arrays.sort(nums);
        int j=0,k=0;
        
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            j = i+1;
            k = nums.length-1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                else if(sum < target) j++;
                else k--;
                if(Math.abs(sum-target) < closest){
                    closest = Math.abs(sum-target);
                    save_state = sum;
                }
            }     
        }
        return save_state;
    }
    
}
