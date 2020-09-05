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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode newHead = new ListNode(-1);
        ListNode curr = head;
        ListNode temp = newHead;
        int removeNum = -1;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                removeNum = curr.val;
                
                while(curr != null && curr.val == removeNum){
                    curr = curr.next;
                }
            }
            else{       
                temp.next = curr;
                temp = curr;
                curr = curr.next;
                temp.next = null;
            }
        }
        return newHead.next;
    }
}
