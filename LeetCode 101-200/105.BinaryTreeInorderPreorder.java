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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recurse(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode recurse(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(preStart >= preorder.length || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int pivot = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preorder[preStart]){
                pivot = i;
                break;
            }
        }
        
        root.left = recurse(preStart+1,inStart,pivot - 1,preorder,inorder);
        root.right = recurse(preStart + pivot - inStart + 1,pivot+1,inEnd,preorder,inorder);
        return root;
        
    }
}
