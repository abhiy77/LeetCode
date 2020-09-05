public class Solution {
    
    public int[][] merge(int[][] intervals) {
        int index = 0;
        int n = intervals.length;
        Collections.sort(Arrays.asList(intervals),new IntervalComparator());
        LinkedList<int[]> result = new LinkedList<>();
        
        for(int[] arr : intervals){
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

class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
      return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    }
}
