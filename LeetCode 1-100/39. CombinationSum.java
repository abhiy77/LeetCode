class Solution {
    
    public void recurse(List<List<Integer>> list ,int[] candidates,int target,int count ,List<Integer> tempList){
        
        if(count > target) return;
        
        if(count == target){
            Collections.sort(tempList);
            List<Integer> temp = new LinkedList<>(tempList);
            
            if(!list.contains(temp))list.add(temp);
            return;
        }
        
         for(int i=0;i<candidates.length;i++){
            tempList.add(candidates[i]);
            recurse(list,candidates,target,count+candidates[i],tempList);
            tempList.remove((Object)candidates[i]);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new LinkedList<Integer>();
        recurse(list,candidates,target,0,tempList);
        return list;
    }
}
