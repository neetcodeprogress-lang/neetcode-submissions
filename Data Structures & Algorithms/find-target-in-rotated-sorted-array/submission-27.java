class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r-l) / 2;

        while (l < r) {

            if(nums[l] == target) return l;
            if(nums[r] == target) return r;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m] && !(nums[l] <= target && target <= nums[m])) {
                l = m + 1;
            } else {
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
