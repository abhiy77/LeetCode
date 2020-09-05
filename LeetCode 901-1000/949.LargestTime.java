class Solution {
    
    private int max_time;
    
    public String largestTimeFromDigits(int[] A) {
        max_time = -1;
        
        permutations(A,0);
        return max_time != -1 ? String.format("%02d:%02d", max_time / 60, max_time % 60) : "";
    }
    
    public void permutations(int A[],int start){
        if(start == A.length){
            checkTime(A);
            return;
        }
        
        for(int i=start;i<A.length;i++){
            swap(A,i,start);
            permutations(A,start+1);
            swap(A,i,start);
        }
    }
    
    public void checkTime(int[] A){
        int hour = A[0] * 10 + A[1];
        int minute = A[2] * 10 + A[3];
        
        if(hour < 24 && minute < 60){
            max_time = Math.max(max_time,hour * 60 + minute);
        }
    }
    
    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
