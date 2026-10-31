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
        int min = -1000;
        int max = 1000;
        return isValidBST(root, min, max);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        
        if(root == null) return true;

        if((root.val < min) || (root.val > max)) {
            return false; // out of range
        }
        
        
        return  isValidBST(root.left, min, root.val - 1) && 
                isValidBST(root.right, root.val + 1, max);
    }

}
