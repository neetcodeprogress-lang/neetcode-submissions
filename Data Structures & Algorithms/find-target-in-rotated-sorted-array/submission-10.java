class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r-l) / 2;

        if(nums.length == 1 && nums[0] == target) return 0;
        if(nums.length == 1 && nums[0] != target) return -1;

        while (l < r) {
            if (nums[m] == target) {
                return m;
            } else if (nums[r] < nums[l]) {
                //move left to mid
                l = m + 1;
                if (nums[l] == target) return l;
            } else {
                r = m;
                if (nums[r] == target) return r;
            }

            m = l + (r-l) / 2;
        }

        if (nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
}
