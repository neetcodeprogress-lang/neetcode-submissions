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

        //check if has children

        boolean left = false;
        boolean right = false;

        if(root.left != null) {
            if(root.left.val >= root.val) {
                return false;
            }
            left = isValidBST(root.left);
        }

        if(root.right != null) {
            if(root.right.val <= root.val) {
                return false;
            }
            right = isValidBST(root.right);
        }
        if((root.left == null && root.right == null) 
        || (root.left == null && root.right != null) 
        || (root.left != null && root.right == null)) {
            return true;
        } else {
        return left && right;            
        }
    }
}
