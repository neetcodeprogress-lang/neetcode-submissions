class Solution {
    public int longestConsecutive(int[] nums) {
        // Turn nums array into a hashset
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            mySet.add(num);
        }

        int count = 0;
        //iterate through the array
        for (int num : mySet) {
            //if num is start of the sequence
                //count how many is in sequence
                //by using while loop
            int tempCount = 1;
        
            
            if (!mySet.contains(num - 1)) { // start of a sequence
                int temp = num;
                while (mySet.contains(temp + 1)) {
                    temp += 1;
                    tempCount += 1;
                }
                temp = 0; //reset temp
                //determine if count or tempcount is larger
                if (tempCount > count) {
                    count = tempCount;
                }
                tempCount = 0;

                //if count is larger then do nothing
            }
        }
        return count;

        
    }
}
