/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         ListNode head = new ListNode(0);
         ListNode temp = head;
         PriorityQueue<LinkedList<Object>> queue = new PriorityQueue<>((a,b) ->((Integer)a.get(0)-(Integer)b.get(0)));
         for(ListNode node : lists){
            if(node != null){
              queue.add(new LinkedList<Object>(Arrays.asList(node.val,node)));
            }
        }
        while(!queue.isEmpty()){
             ListNode check = (ListNode)queue.peek().get(1);
             temp.next = check;
             temp = temp.next;
             if(check.next == null)  queue.poll();
             else{
                 LinkedList<Object> tempList = queue.poll();
                 check = (ListNode)tempList.get(1);
                 check = check.next;
                 queue.add(new LinkedList<Object>(Arrays.asList(check.val,check)));
             }
        }
        return head.next;
    }
}
