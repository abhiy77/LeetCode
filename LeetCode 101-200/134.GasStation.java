class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 1){
            if(gas[0] - cost[0] >= 0) return 0;
            else return -1;
        }
        int n = gas.length;
        ArrayList<Integer> startPos = new ArrayList<>();
        int gasAtPoint[] = new int[n];
        for(int i=0;i<n;i++){
            gasAtPoint[i] = gas[i] - cost[i];
            if(gasAtPoint[i] >= 0)startPos.add(i);
        }
        if(startPos.isEmpty()) return -1;
        int index = startPos.get(0);
        int currGas = gasAtPoint[index];
        int curr = (index+1) % n;
        
        while(curr != index){
            currGas = currGas + gasAtPoint[curr];
            curr = (curr+1)%n;
            if(currGas < 0){
                startPos.remove(0);
                if(startPos.isEmpty()) return -1;
                else{
                    index = startPos.get(0);
                    currGas = gasAtPoint[index];
                    curr = (index + 1) % n;
                }
            }
        }
        return index;
    }
}
