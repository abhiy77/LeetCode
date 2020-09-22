class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows == 0)return result;
        for(int i=1;i<=numRows;i++){
            List<Integer> list = new LinkedList<>();
            for(int j=0;j<i;j++){
                if(i == 1) 
                    list.add(1);
                else if(j == 0 || j == i-1) list.add(1);
                else list.add(result.get(i-2).get(j-1) + result.get(i-2).get(j));
            }
            result.add(list);
        }
        return result;
    }
}
