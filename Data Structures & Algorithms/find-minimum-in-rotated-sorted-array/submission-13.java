class Solution {
    public int findMin(int[] nums) {
        //binary search to find where the cut is
        //if not applicable or found then binary search that window
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0], nums[1]);
        
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r - l) / 2;
        if(nums[l] > nums[r]) {
            while(l <= r) {
                //if m is < prev or > next, we foudn the cut
                m = l + (r - l) / 2;
                if(nums[l] < nums[m]) {
                    //l and m is sorted, move l to m
                    l = m;
                } else if (nums[l] > nums[m]) {
                    r = m;
                } else {
                    break;
                }
            }
        }
        

        //by now should have segment; just binary search
        // while(l < r) {
        //     m = l + (r-l) / 2;
        //     if(l < m) {
        //         r = m - 1;
        //     } else {
        //         l = m + 1;
        //     }
        // }
        // return nums[l];
        return Math.min(nums[l], nums[r]);
    }
}
