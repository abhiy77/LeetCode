/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = 0, len2 = 0;
        while(node1 != null){
            len1++;
            node1 = node1.next;
        }
        while(node2 != null){
            len2++;
            node2 = node2.next;
        }
        node1 = headA;
        node2 = headB;
        if(len1 > len2){
            int diff = len1 - len2;
            while(diff > 0){
                node1 = node1.next;
                diff--;
            }
        }
        else {
            int diff = len2 - len1;
            while(diff > 0){
                node2 = node2.next;
                diff--;
            }
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
        
    }
}
