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
    private boolean bool = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getHeight(root);
        return bool;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 1;
        int left = 0;
        int right = 0;

        if(root.left != null) {
            left = getHeight(root.left);
        }
        if(root.right != null) {
            right = getHeight(root.right);
        }

        int difference = Math.abs(left - right);
        if(difference > 1) bool = false;

        return Math.max(left, right) + 1;
    }
}
