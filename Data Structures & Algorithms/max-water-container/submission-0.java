class Solution {
    public int maxArea(int[] heights) {
        //Max Area = Distance between indexes * height of lowest bar
        //slow solution but maybe just compare all of them?O(n^2)

        int myMaxArea = 0;
        int left = 0;
        int right = 1;
        int distance = 0;
        int myCurrentLowest = 0;
        int tempMaxArea = 0;

        while (left < heights.length - 1) {
            right = left + 1;
            while (right < heights.length) {
                distance = right - left;
                //get lowest
                if (heights[right] > heights[left]) {
                    myCurrentLowest = heights[left];
                } else {
                    myCurrentLowest = heights[right];
                }
                // area = lowestHeight * distance
                tempMaxArea = myCurrentLowest * distance;

                //if temp > current max, set currmax to temp
                if (tempMaxArea > myMaxArea) {
                    myMaxArea = tempMaxArea;
                } 
                right++;
            }
            left++;
        }

        return myMaxArea;
    }
}
