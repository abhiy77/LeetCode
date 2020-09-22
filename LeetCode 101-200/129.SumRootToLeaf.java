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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        calculate(root,"");  
        return result;
    }
    
    public void calculate(TreeNode root,String temp){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result += Integer.valueOf(temp+root.val);
        }
        
        calculate(root.left,temp+root.val);                                                               
        calculate(root.right,temp+root.val);
    }
}
