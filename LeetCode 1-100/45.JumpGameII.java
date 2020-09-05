class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int step = 0;
        while(i<nums.length-1){
            int range = nums[i];
            int nxtPos = i;
            if (nums[i]+i>=nums.length-1) return step+1;
            for (int j=i+1;j<=i+range && j<nums.length;j++){
                nxtPos = (nums[j]+j > nums[nxtPos]+nxtPos) ? j:nxtPos;
            }
            i = (nxtPos==i)?i+nums[i]:nxtPos;
            step++;
        }
        return step;
    }
}
