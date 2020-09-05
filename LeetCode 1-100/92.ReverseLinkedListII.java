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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        
        int count = 1;
        ListNode curr = head;
        while(count < m){
            curr = curr.next;
            count++;
        }
        ListNode start = curr;
        ListNode prev = null;
        curr = curr.next;
        count++;
        
        while(count <= n+1){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        ListNode temp = start.next;
        start.next = prev;
        temp.next = curr;

        return head.next;  
    }
}
