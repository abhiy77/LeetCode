class Solution {
    public int hIndex(int[] citations) {
        
        int k = citations.length;
        
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= k) return k;
            else{
                k--;
            }
        }
        
        return k;
    }
}
