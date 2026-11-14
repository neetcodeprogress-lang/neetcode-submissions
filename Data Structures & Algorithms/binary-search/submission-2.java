class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int mid = (r + l) / 2;

        while (l <= r && mid != l && mid != r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else if (nums[mid] > target){
                r = mid;
            }
            mid = (r + l) / 2;
        }

        return -1;
    }
}
