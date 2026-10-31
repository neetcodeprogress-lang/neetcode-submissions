class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(runningSum < 0) {
                runningSum = 0;
            } 
            runningSum += nums[i];

            if(runningSum > best) best = runningSum;
        }

        return best;
    }
}
