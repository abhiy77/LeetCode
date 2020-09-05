class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        for(int i=1;i<=n;i++){
            recurse(result,i,k,new LinkedList<>(),n);
        }
        return result;
    }
    
    public void recurse(List<List<Integer>> result,int i,int k,List<Integer> temp,int n){
        if(temp.size() == k){
            if(!result.contains(temp)){
                result.add(new LinkedList<>(temp));
                return;
            }
        }
        for(int j=i;j<=n;j++){
            temp.add(j);
            recurse(result,j+1,k,temp,n);
            temp.remove(temp.size()-1);
        }
    }
}
