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
    public ListNode insertionSortList(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode temp = head;
        ListNode curr = temp.next;
        int max = temp.val;
        while(curr != null){
            if(curr.val < max){
                while(temp.val <= curr.val){
                    temp = temp.next;
                }
                while(temp != curr){
                    int val = temp.val;
                    temp.val = curr.val;
                    curr.val = val;
                    temp = temp.next;
                }
             temp = head;
            }
             max = Math.max(max,curr.val);
            curr = curr.next;
        }
        return head;
    }
}
