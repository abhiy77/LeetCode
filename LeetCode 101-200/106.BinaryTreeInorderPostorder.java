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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recurse(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    
public TreeNode recurse(int postEnd,int inStart,int inEnd,int[] inorder,int[] postorder){
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pivot = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == postorder[postEnd]){
                pivot = i;
                break;
            }
        }
        
        root.left = recurse(postEnd+pivot-inEnd-1,inStart,pivot - 1,inorder,postorder);
        root.right = recurse(postEnd-1,pivot+1,inEnd,inorder,postorder);
        return root;
        
    }
}
