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
            } else if (nums[r] < nums[l] && nums[m] > target) {
                r = m;
            } else if (nums[r] < nums[l]) {
                //move left to mid
                if (nums[l] == target) return l;
                l = m + 1;
            }  else {
                if (nums[r] == target) return r;
                r = m;
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
