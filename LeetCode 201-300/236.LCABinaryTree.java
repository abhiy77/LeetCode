/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root,p,q);
        return ans;
    }
    
    public boolean recurse(TreeNode curr,TreeNode p,TreeNode q){
        if(curr == null) return false;
        int left = recurse(curr.left,p,q) ? 1 : 0;
        int right = recurse(curr.right,p,q) ? 1 : 0;
        int mid = (curr == p || curr == q) ? 1 : 0;
        if(mid + left + right >= 2){
            ans = curr;
        }
        return(mid + left + right > 0);
    }
}
