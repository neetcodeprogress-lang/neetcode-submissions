class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] > 0 && nums[i] < nums.length) {
                i += nums[i];
                continue;
            } else if (i == nums.length - 1) { 
                break;
            } else {
                return false;
            }
        }
        return true;
    }
}
