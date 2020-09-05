class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        if(nums.length < 4 ) return list;
            
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++; 
                    }
                    else if(sum < target){
                        k++;
                    }
                    else l--;
                }
            }
        }
        
        HashSet<List<Integer>> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }
}
