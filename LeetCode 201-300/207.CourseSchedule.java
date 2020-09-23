class Solution {
    
    public Queue<Integer> findZeroRank(int[] rank,boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<rank.length;i++){
            if(rank[i] == 0){
                queue.add(i);
                visited[i] = true;
            }
        }
        return queue;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1 || prerequisites.length == 0 )return true;
        List<List<Integer>> adjList = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new LinkedList<>());
        }
        boolean visited[] = new boolean[numCourses];
        int rank[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            rank[prerequisites[i][0]]++;
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = findZeroRank(rank,visited);
        if(queue.isEmpty())return false;
        while(!queue.isEmpty()){
            int element = queue.poll();       
            for(int val : adjList.get(element)){
                rank[val]--;
                if(rank[val] == 0){
                    queue.add(val);
                    visited[val] = true;
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
