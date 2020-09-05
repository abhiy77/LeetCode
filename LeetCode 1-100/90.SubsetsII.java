class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length == 0)return result;
        Arrays.sort(nums);
        List<Integer> temp = new LinkedList<>();
        recurse(result,temp,nums,0);
        return result;
    }
    
    public void recurse(List<List<Integer>> result,List<Integer>temp,int[] nums,int i){
        if(!result.contains(temp)){
            result.add(new LinkedList<>(temp));
        }
        if(i >= nums.length)return;
        
        for(int j = i;j<nums.length;j++){
            temp.add(nums[j]);
            recurse(result,temp,nums,j+1);
            temp.remove(temp.size() - 1);
         }
    }
}
