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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        k = k % len;
        if(k == 0)return head;
        curr = head;
        int move = len - k;
        int temp = 1;
        while(temp != move){
            curr = curr.next;
            temp++;
        }
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = head;
        return next;   
    }
}
