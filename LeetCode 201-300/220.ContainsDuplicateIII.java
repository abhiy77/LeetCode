class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if(t < 0)return false;
        
        TreeSet<Long> set = new TreeSet<>();
        
        for(int i=0;i<nums.length;i++){
            if(!set.subSet((long)nums[i]-t,true,(long)nums[i] +t,true).isEmpty()){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
