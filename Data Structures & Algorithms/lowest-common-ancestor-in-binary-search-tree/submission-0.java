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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isBetween(root, p, q)){
            return root;
        }
        if(isGreater(root, p, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    // helper functions
    public boolean isBetween(TreeNode root, TreeNode p, TreeNode q){
        if(
            (root.val > p.val && root.val < q.val) ||
            (root.val > q.val && root.val < p.val) ||
            (root.val == p.val) ||
            (root.val == q.val)
        ) {
            return true;
        }
        return false;
    }

    public boolean isGreater(TreeNode root, TreeNode p, TreeNode q){
        if((root.val > p.val && root.val > q.val)) {
            return true;
        }
        return false;
    }

    public boolean isLesser(TreeNode root, TreeNode p, TreeNode q){
        if((root.val < p.val && root.val < q.val)) {
            return true;
        }
        return false;
    }
}
