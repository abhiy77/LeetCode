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
    int min = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else if((root.left == null && root.right == null))return 1;
        else recurse(root,1);
        return min;
    }
    
    public int count(TreeNode root,int height){
        if(root == null)return height;
        return Math.min(count(root.left,height+1),count(root.right,height+1));
        
    }
    
    public void recurse(TreeNode root,int height){
        if(root == null)return;
        if(root.left == null && root.right == null){
            min = Math.min(min,height);
        }
        recurse(root.left,height+1);
        recurse(root.right,height+1);
    }
}
