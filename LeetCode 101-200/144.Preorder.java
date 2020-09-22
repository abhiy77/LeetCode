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
    List<Integer> preList = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return preList;
        preOrder(root);
        return preList;
    }
    
    public void preOrder(TreeNode root){
        if(root == null)return;
        preList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
