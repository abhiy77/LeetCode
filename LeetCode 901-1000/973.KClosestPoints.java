class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = calculateDist(points[i]);
        }
        Arrays.sort(dist);
        int distReq = dist[K - 1];
        
        int res[][] = new int[K][2];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(calculateDist(points[i]) <= distReq){
                res[idx++] = points[i];
            }
        }
        return res;
    }
    
    public int calculateDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
