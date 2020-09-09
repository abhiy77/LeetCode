/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> result =new ArrayList<>();
        if(node==null)return result;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        boolean flag = true;
        deque.add(node);
        int count = 1;
        while(!deque.isEmpty()){
            int temp = 0;
            List<Integer> list = new ArrayList<>(); 
            while(count > 0){
                if(flag){
                    TreeNode tempNode = deque.removeLast();
                    list.add(tempNode.val);
                    if(tempNode.right != null){
                        deque.addFirst(tempNode.right);
                        temp++;
                    }
                    if(tempNode.left != null){
                        deque.addFirst(tempNode.left);
                        temp++;
                    }
                    count--;
                }
                if(!flag){
                    TreeNode tempNode = deque.removeFirst();
                    list.add(tempNode.val);
                    if(tempNode.left != null){
                        deque.addLast(tempNode.left);
                        temp++;
                    }
                    if(tempNode.right != null){
                        deque.addLast(tempNode.right);
                        temp++;
                    }
                    count--;
                }
            }
                Collections.reverse(list);
                result.add(list); 

            flag = !flag;
            count = temp;
        }
        return result;
    }
}
