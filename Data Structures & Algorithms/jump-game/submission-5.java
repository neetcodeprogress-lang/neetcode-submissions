class Solution {
    public boolean canJump(int[] nums) {
        //greedy
        //goal starts at end of array; representing last position / index in array
        //from n-1 to 0, check if greater than goal
            //if so, that means we can reach the goal; so move it left
                //move goal left
            //if not, continue on

        //if goal reached 0, return true, else false

        int goal = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0 ? true : false;
    }
}
