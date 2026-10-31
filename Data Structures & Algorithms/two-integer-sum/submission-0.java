class Solution {
    public int[] twoSum(int[] nums, int target) {
        //nested loop that checks if i + j == target
        //if i + j == target add to returnArray

        int [] returnArray = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    //add to returnArray
                    returnArray[0] = i;
                    returnArray[1] = j;
                } 
            }
        }

        return returnArray;
    }
}
