class Solution {
     public int hIndex(int[] citations) {
        int[] intermediate = new int[citations.length+1];
        
        for(int citation : citations){
            if(citation > citations.length){
                intermediate[citations.length] +=1;
            } else {
                 intermediate[citation] +=1;
            }
        }
        
        int runningSum=0;
        for(int i=intermediate.length-1;i>=0;i--){
            runningSum += intermediate[i];
            if(runningSum >= i) return i;
        }
        return 0;
    }
}
