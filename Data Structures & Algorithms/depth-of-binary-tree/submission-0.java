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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return maxDepth;
        calculateDepth(root, 0);
        return maxDepth;
    }

    public void calculateDepth(TreeNode node, int depth) {
        if(node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        calculateDepth(node.left, depth+1);
        calculateDepth(node.right, depth+1);
    }
}
