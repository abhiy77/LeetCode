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
        int currNum = Integer.MIN_VALUE;

        while(curr != null){
            if(curr.val == currNum){
               curr = curr.next; 
            }
            else{     
                currNum = curr.val;
                temp.next = curr;
                temp = curr;
                curr = curr.next;
                temp.next = null;      
            }
        }
        return newHead.next;
    }
}
