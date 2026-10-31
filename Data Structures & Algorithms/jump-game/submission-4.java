class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                //if index + number at index can reach the goal
                //move goal over
                goal = i;
            }
        }

        return goal == 0 ? true : false;
    }
}
