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

        //check children of current root, if they are p and q return root
        //if root is p or q just try returning p or q
        // if((root.left == p && root.right == q) || (root.right == p && root.left == q)) {
        //     return root;
        // }

        if(root.left != null && root.right != null && p != null && q != null) {
            if((root.left.val == p.val && root.right.val == q.val) || (root.right.val == p.val && root.left.val == q.val)) {
                return root;
            }
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null) return left;
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        return root;
    }
}
