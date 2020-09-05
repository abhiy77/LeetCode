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
     List<List<Integer>> result;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<>();
        if(root == null) return result;
        getLevelOrder(root);
        Collections.reverse(result);
        return result;
    }
    
     public void getLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int temp = 0;
        while(!queue.isEmpty() && count != 0){
            
            List<Integer> list = new LinkedList<>();
            temp = 0;
            while(count != 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                count--;
                if(node.left != null){
                    queue.add(node.left);
                    temp++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    temp++;
                } 
            }       
            count = temp;
            result.add(list);
        }
    }
}
