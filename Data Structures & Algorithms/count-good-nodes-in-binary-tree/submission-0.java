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
    private int gNCount = 0;
    public int goodNodes(TreeNode root) {

        if(root == null) return 0;
        gNCount++; //root is always a good node

        dfs(root.left, root.val);
        dfs(root.right, root.val);

        return gNCount;
    }
    public void dfs(TreeNode root, int largestInPath) {
        if(root == null) return;

        if(root.val >= largestInPath) {
            //good node
            gNCount++;
            if(root.val > largestInPath) {
                largestInPath = root.val;
            }
        }
        
        dfs(root.left, largestInPath);
        dfs(root.right, largestInPath);
        
    }
}
