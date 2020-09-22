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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        findPaths(root,sum,list,temp);
        return list;
    }
    
    public void findPaths(TreeNode root,int sum,List<List<Integer>> list,List<Integer> temp){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(sum == root.val){
                temp.add(sum);
                List<Integer> clone = new LinkedList<>();
                clone.addAll(temp);
                list.add(clone);
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        findPaths(root.left,sum-root.val,list,temp);
        findPaths(root.right,sum-root.val,list,temp);
        temp.remove(temp.size()-1);    
    }
}
