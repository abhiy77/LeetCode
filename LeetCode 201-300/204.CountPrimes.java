class Solution {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime,true);
        
        for(int i=2;i*i < isPrime.length;i++){
            if(isPrime[i]){
                for(int j = i*i;j<isPrime.length;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i])count++;
        }
        
        return count;
    }
}
