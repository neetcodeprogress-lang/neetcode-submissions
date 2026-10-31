// import java.util.Set;
// import java.util.HashSet;
class Solution {
    public boolean hasDuplicate(int[] nums) {
        //create set, throw it in set, compare lengths
        Set<Integer> mySet = new HashSet<Integer>();

        for (int integer : nums) {
            mySet.add(integer);
        }

        return mySet.size() != nums.length;
    }
}