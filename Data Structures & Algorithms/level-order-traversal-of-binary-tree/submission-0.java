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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int elements = queue.size();
            List<Integer> subList = new ArrayList<>();
            while(elements != 0) {
                TreeNode node = queue.remove();
                if(node.left != null) { queue.add(node.left); }
                if(node.right != null) { queue.add(node.right); }

                subList.add(node.val);
                elements--;
            }
            list.add(subList);
        }
        return list;
    }
}
