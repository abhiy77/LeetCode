class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        if(n == 0)return 0;
        
        for(int i=0;i<n;i++){
            time[i] %= 60;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i=0;i<n;i++){
            int rem = (60 - time[i]) % 60;
            count += map.getOrDefault(rem,0);
            map.put(time[i],map.getOrDefault(time[i],0) + 1);
        }
        return count;
    }
}
