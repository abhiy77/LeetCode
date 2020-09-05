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
    
    public boolean isValidBST(TreeNode root) {
        int sum = 12;
        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toBinaryString(-sum));
        System.out.println(Integer.toBinaryString(sum & -sum));
        return recurse(root,null,null);
    }
    
    public boolean recurse(TreeNode node,Integer lower,Integer upper){
        if(node == null) return true;
        if(!recurse(node.left,node.val,upper))return false;
        if(!recurse(node.right,lower,node.val))return false;
        
        if(lower != null && node.val >= lower)return false;
        if(upper != null && node.val <= upper) return false;
        return true;
    }   
}
