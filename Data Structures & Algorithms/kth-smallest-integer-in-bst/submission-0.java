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
    public int kthSmallest(TreeNode root, int k) {
        //iterate thru dfs, add to list in order of dfs
        //go to position k - 1(1 indexed) and return the int there
        List<Integer> myList = new ArrayList<>();

        if (root == null) return 0;

        dfs(root, myList);

        return myList.get(k - 1);
    }

    public void dfs(TreeNode root, List<Integer> myList) {
        if(root != null) {
            dfs(root.left, myList);
            myList.add(root.val);
            dfs(root.right, myList);
        }
        
    }
}
