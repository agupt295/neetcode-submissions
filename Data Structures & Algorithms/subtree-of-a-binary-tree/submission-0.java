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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        else if(root.val == subRoot.val) {
            if(isSameTree(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p1, TreeNode p2) {
        if(p1 == null && p2 == null) return true;
        if((p1 == null && p2 != null) ||
           (p1 != null && p2 == null) ||
           (p1.val != p2.val)) {
            return false;
        }
        return isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }
}
