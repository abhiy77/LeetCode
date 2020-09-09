class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        temp.add(nums[i]);
        int c = nums[i++];
        
        while(i < nums.length){
            if(nums[i] == c + 1){
                temp.add(nums[i++]);
                c += 1;
            }
            else{
                addString(list,temp);
                temp.clear();
                c = nums[i++];
                temp.add(c);
            }
        }
        if(temp.size() > 0){
            addString(list,temp);
        }
        return list;
    }
    
    public void addString(List<String> list,List<Integer> temp){
        if(temp.size() == 1){
            list.add(temp.get(0) + "");
        }
        else{
            int start = temp.get(0);
            int end = temp.get(temp.size() - 1);
            String str = start + "->" + end;
            list.add(str);
        }
    }
}
