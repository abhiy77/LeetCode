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
    
    public void flatten(TreeNode root) {
        if(root == null)return;
        List<TreeNode> nodes = new LinkedList<>();
        preorder(root,nodes);
        for(int i=1;i<nodes.size();i++){
            root.left = null;
            root.right = nodes.get(i);
            root = root.right;
        }
    }
    
    public void preorder(TreeNode node,List<TreeNode> nodes){
        if(node == null) return;
        nodes.add(node);
        preorder(node.left,nodes);
        preorder(node.right,nodes);
    }
}
