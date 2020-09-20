class NumArray {
    private int cumsum[];

    public NumArray(int[] nums) {
        cumsum = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            cumsum[i+1] = cumsum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return cumsum[j+1] - cumsum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
