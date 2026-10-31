class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int mid = (r + l) / 2;

        // if (nums.length == 1) {
        //     return target == nums[0] ? 0 : -1;
        // } else if (nums.length == 2) {
        //     if (nums[0] == target) {
        //         return 0;
        //     } else if (nums[1] == target) {
        //         return 1;
        //     } else {
        //         return -1;
        //     }
        // }

        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target){
                r = mid - 1;
            }
            mid = (r + l) / 2;
        }

        return -1;
    }
}
