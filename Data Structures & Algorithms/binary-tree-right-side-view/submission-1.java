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
    public List<Integer> rightSideView(TreeNode root) {

        //Create arraydeque
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        //create return list: result
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        //add root to arraydeque
        deque.addLast(root);



        //while arraydeque isn't empty
        while(!deque.isEmpty()) {
            int size = deque.size();
            //for loop, each level
            for(int i = 0; i < size; i++) {
                //pop from front
                TreeNode popped = deque.removeFirst();

                //add it's children to deque
                if(popped.left != null) deque.addLast(popped.left);
                if(popped.right != null) deque.addLast(popped.right);

                //if i + 1 == size
                if(i + 1 == size) {
                    //its the last in the lvl, 
                    //add it to the return list
                    result.add(popped.val);
                }
            }
        }
        return result;
    }
}
