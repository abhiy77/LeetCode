/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty() && count > 0){
            int temp = 0;
            while(count > 0){
               Node n = queue.poll();
                count--;
               if(n.left != null){
                   queue.add(n.left);
                   temp++;
               }
                if(n.right != null){
                   queue.add(n.right);
                   temp++;
               }
            }
            count = temp;
            for(int i=0;i<queue.size()-1;i++){
                queue.get(i).next = queue.get(i+1);
            } 
        }
        return root;
    }
}
