
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, prev = null,next = null;
        prev = curr;
        int count =0;
        while(prev !=null){
            prev = prev.next;
            count++;
        }
        if(prev == null && count<k) return curr;
        count = 0;
        while(curr != null && count !=k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(curr!= null){
            head.next = reverseKGroup(next,k);
        }
        return prev;
    }
}
