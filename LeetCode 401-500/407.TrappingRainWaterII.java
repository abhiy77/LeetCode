class Solution {
    
    class Pos {
        public int val;
        public int i;
        public int j;
        
        public Pos(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
        
        public String toString(){
            return "[" +  i + "," + j + "," + val + "]";
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pos> minheap = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for (int j=0; j<heightMap[0].length; j++) {
            minheap.add(new Pos(heightMap[0][j], 0, j));
            minheap.add(new Pos(heightMap[heightMap.length-1][j], heightMap.length-1, j));
            heightMap[0][j] = -1;
            heightMap[heightMap.length-1][j] = -1;
        }

        for (int i=0; i<heightMap.length; i++) {
            minheap.add(new Pos(heightMap[i][0], i, 0));
            minheap.add(new Pos(heightMap[i][heightMap[0].length-1], i, heightMap[0].length-1));
            heightMap[i][0] = -1;
            heightMap[i][heightMap[0].length-1] = -1;
        }
        
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int res = 0;
                        
        while (!minheap.isEmpty()) {
            Pos p = minheap.remove();
            
            int val = p.val;
            int i = p.i;
            int j = p.j;
            
            for (int k=0; k<dir.length; k++) {
                int ni = i+dir[k][0];
                int nj = j+dir[k][1];
                
                if (ni < 0 || ni>heightMap.length-1 || nj < 0 || nj > heightMap[0].length-1 || heightMap[ni][nj] == -1) {
                    continue;
                }
                
                if (heightMap[ni][nj] < val) {
                    res+=(val-heightMap[ni][nj]);
                    minheap.add(new Pos(val, ni, nj));
                    heightMap[ni][nj] = -1;
                } else {
                    minheap.add(new Pos(heightMap[ni][nj], ni, nj));
                    heightMap[ni][nj] = -1;
                }

            }
        }
        return res;
    }
}
