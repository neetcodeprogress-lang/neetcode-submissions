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
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);

        if(root == null) return null;

        if(root.val >= min && root.val <= max) {
            return root;
        } else if (root.val <= min) {
            //search right subtree    
            return lowestCommonAncestor(root.right, p, q);
        } else {
            //search left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
