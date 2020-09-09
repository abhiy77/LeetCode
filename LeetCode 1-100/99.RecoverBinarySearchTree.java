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

    public void recoverTree(TreeNode root) {
        ScanInfo scanInfo = new ScanInfo();
        recoverTree(root, scanInfo);
        if(scanInfo.wrongNode1 != null) {
            int swapTemp = scanInfo.wrongNode1.val;
            scanInfo.wrongNode1.val = scanInfo.wrongNode2.val;
            scanInfo.wrongNode2.val = swapTemp;
        }
    }

    private void recoverTree(TreeNode node, ScanInfo info) {
        if(node == null) {
            return;
        }

        recoverTree(node.left, info);

        if(info.lastNode == null || node.val > info.lastNode.val) {
            info.lastNode = node;
        } else if (info.wrongNode1 == null) {
            info.wrongNode1 = info.lastNode;
            info.wrongNode2 = node;
        } else {
            info.wrongNode2 = node;
        }

        recoverTree(node.right, info);

    }

    private static class ScanInfo {
        TreeNode lastNode;
        TreeNode wrongNode1;
        TreeNode wrongNode2;

        ScanInfo(TreeNode last, TreeNode wrongNode1, TreeNode wrongNode2) {
            this.lastNode = lastNode;
            this.wrongNode1 = wrongNode1;
            this.wrongNode2 = wrongNode2;
        }

        ScanInfo() {}
    }
}
