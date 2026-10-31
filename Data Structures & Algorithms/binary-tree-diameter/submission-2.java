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
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode root) {
        int l = 0;
        int r = 0;
        if(root.left != null) {
            l = getHeight(root.left);
        }
        if(root.right != null) {
            r = getHeight(root.right);
        }

        max = Math.max(max, l + r);

        return Math.max(l, r) + 1; //return height
    }
}
