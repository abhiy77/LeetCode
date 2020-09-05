/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null) return head.next;
        ListNode temp = head;
        for(int i=0;i<n;i++){
            temp = temp.next;
        }
        if(temp == null) return head.next;
        ListNode helperNode = head;
        while(temp.next != null){
            temp = temp.next;
            helperNode = helperNode.next;
        }
        
        helperNode.next = helperNode.next.next;
     
        return head;   
    }
}
