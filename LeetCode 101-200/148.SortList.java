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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        else return sort(head);
    }
    
    public ListNode sort(ListNode node){
        if(node == null || node.next == null)return node;
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        
        ListNode first = sort(node);
        ListNode second = sort(fast);
        
        return merge(first,second);
    }
    
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(head1 != null && head2 != null){
            if(head1.val > head2.val){
               res.next = new ListNode(head2.val);
               head2 = head2.next;
            }
            else{
               res.next = new ListNode(head1.val);
               head1 = head1.next;
            }
            res = res.next;
        }
        while(head1 != null){
            res.next = new ListNode(head1.val);
            head1 = head1.next;
            res = res.next;
        }
        while(head2 != null){
            res.next = new ListNode(head2.val);
            head2 = head2.next;
            res = res.next;
        }
        return temp.next;
    }
}
