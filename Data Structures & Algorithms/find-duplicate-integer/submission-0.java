class Solution {
    public int findDuplicate(int[] nums) {
        //add to set
        HashSet<Integer> mySet = new HashSet<>();
        //if num already exists, return num; else add to set
        for(int num : nums) {
            if (mySet.contains(num)) {
                return num;
            } else {
                mySet.add(num);
            }
        }

        return -1;
        //return -1 //didn't find duplicate
    }
}
