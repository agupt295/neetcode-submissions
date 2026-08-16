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
    int count = 0;
    public int goodNodes(TreeNode root) {
        findGoodNodes(root, root.val);
        return count;
    }

    public void findGoodNodes(TreeNode node, int val){
        if(node == null) { return; }
        if(node.val >= val) {
            count++;
        }
        findGoodNodes(node.left, Math.max(val, node.val));
        findGoodNodes(node.right, Math.max(val, node.val));
    }
}
