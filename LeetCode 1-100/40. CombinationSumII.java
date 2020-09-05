class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new LinkedList<Integer>();
        recurse(list,candidates,target,0,tempList,-1);
        return list;
    } 
    
     public void recurse(List<List<Integer>> list ,int[] candidates,int target,int count ,List<Integer> tempList,int num){
        if(count > target) return;
        
        if(count == target){
        	Collections.sort(tempList);
        	List<Integer> temp = new LinkedList<>(tempList);
            if(!list.contains(temp))list.add(temp);
            return;
        }
        
         for(int i=num+1;i<candidates.length;i++){
            tempList.add(candidates[i]);
            recurse(list,candidates,target,count+candidates[i],tempList,i);
            tempList.remove((Object)candidates[i]);
        }
    }
}
