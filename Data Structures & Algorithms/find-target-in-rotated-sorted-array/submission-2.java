class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r-l) / 2;

        if(nums.length == 1) return nums[0];

        while (l < r) {
            if (nums[m] == target) {
                return m;
            } else if (nums[r] < nums[l]) {
                //move left to mid
                l = m + 1;
            } else {
                r = m;
            }

            m = l + (r-l) / 2;
        }

        return -1;
    }
}
