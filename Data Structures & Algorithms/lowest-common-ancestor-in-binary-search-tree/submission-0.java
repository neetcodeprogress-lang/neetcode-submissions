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
        //dfs, if we get to a node where left or right == p and respective left or right == q
        //then just return current nod

        if(root == null) return null;
        
        if(root.val == p.val) {
            if((root.left != null && q != null && root.left.val == q.val) ||
                (root.right != null && q != null && root.right.val == q.val)) {
                return root;
            }
        } else if (root.val == q.val) {
            if((root.left != null && p != null && root.left.val == p.val) ||
                (root.right != null && p != null && root.right.val == p.val)) {
                return root;
            }
        } else {
            //check children
            if (root.left == p) {
                if(root.right == q) return root;
            } else if(root.left == q) {
                if(root.right == p) return root;
            }
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        } else {
            return left;
        }
    }
}
