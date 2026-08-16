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
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            int elements = queue.size();
            TreeNode rightNode = null;
            while(elements != 0) {
                TreeNode node = queue.remove();
                rightNode = node;
                
                if(node.left != null) { queue.add(node.left); }
                if(node.right != null) { queue.add(node.right); }
                elements--;
            }
            list.add(height, rightNode.val);
            height++;
        }
        return list;
    }
}
