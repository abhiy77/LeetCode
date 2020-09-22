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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int h1 = count(root.left,1);
        int h2 = count(root.right,1);
        if(Math.abs(h1 - h2) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int count(TreeNode root,int height){
        if(root == null) return height;
        return Math.max(count(root.left,height+1),count(root.right,height+1));
    }
}
