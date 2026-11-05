class Solution {
    public int rob(int[] nums) {
        //starting from the end, what is the maximum amount of money each position 
        //can have(accounting for any potential skips)

        int res = 0;

        int[] maxAmount = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i > nums.length - 3) {
                //we are in the last two indices; just have those be num[i]
                maxAmount[i] = nums[i];
            } else if (i == nums.length - 3) {
                maxAmount[i] = nums[i] + maxAmount[i + 2];
            } else {
                maxAmount[i] = nums[i] + Math.max(maxAmount[i + 2], maxAmount[i+3]);
            }
            res = Math.max(res, maxAmount[i]);

        }

        //maxAmount[i]
        //maxAmount[3] = 3
        //maxAmount[2] = 3
        //maxAmount[1] = 4
        //maxAmount[0] = 4

        //2  9  8  3 6             

        //16 15 14 3 6
        
        //return the res(max of maxAmount)
        return res;
    }
}
