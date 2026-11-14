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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        int maxLeft = 0;
        int minRight = 0;

        if(root.left != null) {
            maxLeft = getMax(root.left);
        }

        if(root.right != null) {
            minRight = getMin(root.right);
        }
        
        return maxLeft <= root.val && root.val <= minRight;
    }

    public int getMax(TreeNode root) {
        TreeNode traverse = root;
        while(traverse.right != null) {
            traverse = traverse.right;
        }
        return traverse.val;
    }

    public int getMin(TreeNode root) {
        TreeNode traverse = root;
        while(traverse.left != null) {
            traverse = traverse.left;
        }
        return traverse.val;
    }

}
