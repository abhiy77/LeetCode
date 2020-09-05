class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length <= 2) return nums;
        int n = nums.length;
        int res[] = new int[2];
        int sum = 0;
        for(int num : nums){
            sum ^= num;
        }
        sum = sum & -sum;
        
        for(int num : nums){
            if((sum & num) == 0){
                res[0] ^= num;
            }
            else res[1] ^= num;
        }
        return res;
    }
}
