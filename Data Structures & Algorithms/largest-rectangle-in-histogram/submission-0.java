class Solution {
    public int largestRectangleArea(int[] heights) {
        //can't sort it --> changes areas
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            int left = 1;
            int right = 1;
            int width = left + right - 1;
            //find values for left and right
            //while (we can go left and right) {
            while (i - left >= 0 && heights[i-left] >= heights[i]) {
                //if can go left increment left
                left++;
            }
            while (i + right < heights.length && heights[i+right] >= heights[i]) {
                //if can go right increment right
                right++;
            }
            //should now have width
            width = right + left - 1;
            //check if width * height > max, if so assign to max
            if (width * heights[i] > max) {
                max = width * heights[i];
            }
        }
        return max;
    }
}
