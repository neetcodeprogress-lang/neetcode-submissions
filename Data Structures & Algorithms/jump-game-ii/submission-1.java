class Solution {
    public int jump(int[] nums) {
        //review
        //use bfs approach; l and r represent our "queue"

        int l = 0;
        int r = 0;
        int count = 0;
        while(r < nums.length - 1) {
            int farthest = 0;
            for(int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r + 1;
            r = farthest;
            count++;
        }
        return count;
    }
}
