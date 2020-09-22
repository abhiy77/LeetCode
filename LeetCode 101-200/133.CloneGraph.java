/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Deque<Node> deque = new ArrayDeque<>();
        deque.offerFirst(node);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,new Node(node.val));
        
        while(!deque.isEmpty()){
            int n = deque.size();
            for(int i=0;i<n;i++){
                Node temp = deque.pollLast();
                for(Node neb : temp.neighbors){
                    if(map.containsKey(neb)){
                        map.get(temp).neighbors.add(map.get(neb));
                    }
                    else{
                        map.put(neb,new Node(neb.val));
                        map.get(temp).neighbors.add(map.get(neb));
                        deque.offerFirst(neb);
                    }
                }
            }
        }
        return map.get(node);
    }
}
