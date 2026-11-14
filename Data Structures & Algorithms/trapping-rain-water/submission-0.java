class Solution {
    public int trap(int[] height) {
        //if it touches the edge then it doesn't count
            //any of those that lead to the edge does not count

        //Find the outermost bars
        int l = 0;
        int r = l + 1;

        int totalRainWater = 0;
        int unvalidatedSum = 0;
        while (r < height.length) {
            if (height[l] <= height[r]) {
                //increment right, set l to r
                l = r;
                r++;
                totalRainWater += unvalidatedSum;
                unvalidatedSum = 0;
            } else {
                unvalidatedSum += height[l] - height[r];
                r++; 
            }
            //if right reaches end and left isnt behind or on it, there is a leak

        }

        return totalRainWater;

        //then find the area between them and calculate how much water we can trap
        //0 4, 3, 1, 3, 4, 2, 1, 4, 4
    }
}
