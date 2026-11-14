class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int mid = (r + l) / 2;

        while (l < r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (mid == l) return -1;
                l = mid;
            } else if (nums[mid] > target){
                if(mid == r) return -1;
                r = mid;
            }
            mid = (r + l) / 2;
        }

        return -1;
    }
}
