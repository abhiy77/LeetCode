class Solution {
    public int[] findOrder(int numCourses, int[][] adj) {
        int[] arr = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int idx = 0;
        if(numCourses == 1){
            arr[0] = 0;
            return arr;
        }
        
        int rank[] = new int[numCourses];
        for(int i=0;i<adj.length;i++){
            rank[adj[i][0]]++;
            
            adjList.get(adj[i][1]).add(adj[i][0]);
        }
        
        Queue<Integer> queue = getCourses(rank);
        
        if(queue.size() == 0)return new int[0];
        while(!queue.isEmpty()){
            int val = queue.poll();
            arr[idx++] = val;
            List<Integer> list = adjList.get(val);
            for(int v : list){
                rank[v]--;
                if(rank[v] == 0){
                    queue.add(v);
                }
            }
        }
        if(idx == numCourses) return arr;
        else return new int[0];
 
    }
    
    public Queue<Integer> getCourses(int[] rank){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<rank.length;i++){
            if(rank[i] == 0) queue.add(i);
        }
        return queue;
    }
}
