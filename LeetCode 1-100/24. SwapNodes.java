/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode support = new ListNode(0);
        support.next = head;
        ListNode result = support;
        while (support.next != null && support.next.next != null ) {
            ListNode pair1 = support.next;
            ListNode pair2 = support.next.next;
            pair1.next = pair2.next;
            pair2.next = pair1;
            support.next = pair2;
            support = pair1;
        }
        return result.next;
    }
}
