/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null && l2 == null) return null;
        ListNode head = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1 != null && l2 !=null) head = (l1.val > l2.val ? l2 : l1);

        if(l1 .val > l2.val) l2 = l2.next;
        else l1 = l1.next;
        ListNode temp = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val) {temp.next = l2 ; l2 = l2.next; }
            else {temp.next = l1 ;l1 = l1.next;}
            temp = temp.next;
        }
        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
         while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }
}
