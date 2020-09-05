public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        int flag = 0;
        for(int[] interval : intervals){
            if(interval[0] < newInterval[0]){
                list.add(interval);
            }
            else if(flag == 0){
                list.add(newInterval);
                list.add(interval);
                flag = 1;
            }
            else{
                list.add(interval);
            }
        }
        if(flag == 0 && newInterval.length > 0) list.add(newInterval);

        LinkedList<int[]> result = new LinkedList<>();
        
        for(int[] arr : list){
            if(result.isEmpty() || result.getLast()[1] < arr[0]){
                result.add(arr);
            }
            else{
                result.getLast()[1] = Math.max(result.getLast()[1],arr[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
