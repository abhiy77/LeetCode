/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        dfs(head);
    }
    
    public void dfs(ListNode node){
        if(node == null || node.next == null || node.next.next == null)return;
        ListNode curr = node;
        ListNode next = curr.next;
        ListNode prev = null;
        
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        
        node.next = curr;
        curr.next = next;
        prev.next = null;
        dfs(next);
    }
}
