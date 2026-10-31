class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int m = (l + r) / 2;

        if (nums[l] <= nums[m] && nums[m] <= nums[r]) {
            return nums[l];
        }

        while(l < r) {
            m = (l + r) / 2;
            if (nums[l] <= nums[m]) { //close in left
                l = m + 1;
                if (nums[l] < nums[m]) return nums[l];
            } else {
                //close in right
                r = m;
            }
        }
        return nums[l];
    }
}
