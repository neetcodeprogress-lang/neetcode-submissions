class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        //if it touches the edge then it doesn't count
            //any of those that lead to the edge does not count


        int l = 0;
        int r = 0;

        int totalRainWater = 0;
        
        for(int i = 0; i < height.length; i++) {
            //reset l and r
            l = height[i];
            r = height[i];

            //Find the outermost bars

                //find l max
            for(int n = 0; n < i; n++) {
                l = Math.max(l, height[n]);
            }
                //find r max
            for(int n = i + 1; n < height.length; n++) {
                r = Math.max(r, height[n]);
            }
            //get the minimum column and add it to total rain water
            totalRainWater += Math.min(l, r) - height[i];
        }

        return totalRainWater;

        //0 4, 3, 1, 3, 4, 2, 1, 4, 4
    }
}
