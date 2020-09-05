class Solution {
    
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        int swapIndex = -1;
        for(int i=nums.length-2;i>=0;i--){
           if(nums[i] < nums[i+1]){
               swapIndex = i;
               break;
           }
        }
        if(swapIndex == -1) {Arrays.sort(nums); return;}
        int min = swapIndex + 1;
        for(int i = swapIndex+2;i<nums.length;i++){
            if(nums[i] > nums[swapIndex] && nums[i] < nums[min]){
                min = i;
            }
        }
        swap(nums,swapIndex,min);
        Arrays.sort(nums,swapIndex+1,nums.length);
    }
    
}
