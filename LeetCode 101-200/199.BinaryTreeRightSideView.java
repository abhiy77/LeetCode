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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList<>();
        TreeNode node = root;
        HashMap<Integer,Integer> map = new HashMap<>();
        recurse(map,node,0);
        return new ArrayList<Integer>(map.values());
    }
    
    public void recurse(HashMap<Integer,Integer> map,TreeNode node,int depth){
        if(node == null)return;
        recurse(map,node.right,depth+1);
        if(!map.containsKey(depth))map.put(depth,node.val);
        recurse(map,node.left,depth+1);
    }
}
