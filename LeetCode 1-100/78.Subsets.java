class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            recurse(result,i,nums,new LinkedList<>());
        }
        return result;
    }
    
    public void recurse(List<List<Integer>> result,int i,int[] nums,List<Integer> temp){
        if(!result.contains(temp)){
            result.add(new LinkedList<>(temp));
         }
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            recurse(result,j+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}
