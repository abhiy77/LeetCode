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
    
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        recurse(root,L,R);
        return ans;
    }
    
    public void recurse(TreeNode node,int L,int R){
        if(node == null)return;
        if(L <= node.val && node.val <= R){
            ans += node.val;
        }
        if(L < node.val){
            recurse(node.left,L,R);
        }
        if(R > node.val){
            recurse(node.right,L,R);
        }
    }
    
}
