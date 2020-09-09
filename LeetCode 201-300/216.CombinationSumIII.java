class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>(); 
        recurse(n,k,new HashSet<>());
        return list;
    }
    
    public void recurse(int n,int k,Set<Integer> set){
        if(n == 0 && k == 0){
            ArrayList<Integer> temp = new ArrayList<>(set);
            if(!list.contains(temp)){
                list.add(temp);
                return;
            }
        }
        if(n <= 0 || k <= 0) return;
        
        for(int j=1;j<=9;j++){
            if(set.contains(j))continue;
            set.add(j);
            recurse(n-j,k-1,set);
            set.remove(j);
        }
    }
}
