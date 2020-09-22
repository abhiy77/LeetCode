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
    List<Integer> postList = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return postList;
        postOrder(root);
        return postList;
    }
    public void postOrder(TreeNode root){
        if(root == null)return;
        postOrder(root.left);
        postOrder(root.right);
        postList.add(root.val);
    }
}
