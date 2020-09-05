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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Coor>> map = new TreeMap<>();
        recurse(root,0,0,map);
        List<List<Integer>> res = new ArrayList<>();
        
        for(Map.Entry<Integer,List<Coor>> entry : map.entrySet()){
            Collections.sort(entry.getValue(),(coor1,coor2)->
                             {if(coor2.y != coor1.y)return coor2.y - coor1.y;
                             else return coor1.val - coor2.val;});
            List<Coor> list = entry.getValue();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                temp.add(list.get(i).val);
            }
            res.add(temp);
        }
        return res;
    }
    
    public void recurse(TreeNode node,int x,int y,TreeMap<Integer,List<Coor>> map){
        
        if(node == null)return;
        
        if(!map.containsKey(x)){
            map.put(x,new ArrayList<>());
        }
        map.get(x).add(new Coor(y,node.val));
        
        recurse(node.left,x-1,y-1,map);
        recurse(node.right,x+1,y-1,map);
        
    }
}

class Coor{
    int y,val;
    Coor(int y,int val){
        this.y = y;
        this.val = val;
    }
}
