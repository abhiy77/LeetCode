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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.val == val)) return null;
        ListNode curr = head;   
        if(curr.val == val){
            while(curr != null && curr.val == val){
                curr = curr.next;
            }
            if(curr == null)return null;
            else head = curr;
        }
        ListNode prev = null;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;   
    }
}
