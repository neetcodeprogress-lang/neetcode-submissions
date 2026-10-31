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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        if(root == null) return bigList;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> smallList = new ArrayList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                TreeNode tNode = deque.removeFirst();
                smallList.add(tNode.val);
                if(tNode.left != null) {
                    deque.addLast(tNode.left);
                }
                if(tNode.right != null) {
                    deque.addLast(tNode.right);
                }
            }
            bigList.add(smallList);
            smallList = new ArrayList<>();
        }
        return bigList;
    }
}
