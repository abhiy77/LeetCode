class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0)return 0;
        int num = nums[0];
        int freq = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == num)freq++;
            else{
                if(freq == 0){
                    num = nums[i];
                    freq = 1;
                }
                else freq--;
            }
        }
        return num;
    }
}
