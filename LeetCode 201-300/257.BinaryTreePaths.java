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
    List<String> result = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)return result;
        recurse(root,"");
        return result;
    }
    public void recurse(TreeNode root,String s){
        if(root == null)return;
        if(root.left == null && root.right == null){
            result.add(s+root.val);
            return;
        }
        recurse(root.left,s+root.val+"->");
        recurse(root.right,s+root.val+"->");
    }
}
