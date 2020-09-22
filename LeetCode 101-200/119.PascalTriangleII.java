class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        for(int i=0;i<=rowIndex;i++) {
            result.add(0);
        }
        for(int i=1;i<=rowIndex+1;i++){
            List<Integer> temp = new LinkedList<>(result);
            for(int j=0;j<i;j++){
                if(i == 1) 
                    result.set(i-1,1);
                else if(j == 0 || j == i-1) result.set(j,1);
                else result.set(j,temp.get(j-1) + temp.get(j));
            }
        }
        return result;
    }
}
