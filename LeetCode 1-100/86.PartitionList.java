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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);
        ListNode temp_before = before_head;
        ListNode temp_after = after_head;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                temp_before.next = curr;
                temp_before = curr;
                curr = curr.next;
                temp_before.next = null;
            }
            else{
                temp_after.next = curr;
                temp_after = curr;
                curr = curr.next;
                temp_after.next = null;
            }   
        }
        
        temp_before.next = after_head.next;
        return before_head.next;
    }
}
