/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        Node temp = new Node(-1);      
        Node move = temp;
        curr = head;
        while(curr != null) {
            Node node = map.get(curr);
            Node randomNode = map.get(curr.random);
            node.random = randomNode;
            move.next = node; 
            move = move.next; 
            curr = curr.next; 
        }
        return temp.next;
    }
}
