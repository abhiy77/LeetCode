class Solution {
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums = new LinkedList<>();
        PriorityQueue<String> queue = new PriorityQueue<>((a,b)->a.compareTo(b));
        for(int i=1;i<=n;i++){
            queue.add(""+i);
        }
        while(!queue.isEmpty()){
            nums.add(Integer.parseInt(queue.poll()));
        }
        return nums;
    }
}
