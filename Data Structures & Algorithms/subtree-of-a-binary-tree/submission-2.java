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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }


        if(root == null && subRoot == null) return true;
        boolean left = false;
        boolean right = false;
        if(root.val == subRoot.val) {
            // start comparison
            boolean bool = isSameTree(root, subRoot);
            if(bool) {
                return bool;
            }
        }
        left = isSubtree(root.left, subRoot);
        right = isSubtree(root.right, subRoot);
        

        return (left || right);
               

    }

    public boolean isSameTree(TreeNode t, TreeNode n) {
        if((t == null && n != null) || (t != null && n == null)) {
            return false;
        }

        if(t == null && n == null) return true;

        if(t.val != n.val) {
            return false;
        }

        boolean left = isSameTree(t.left, n.left);
        boolean right = isSameTree(t.right, n.right);

        return (left && right);
    }


}
