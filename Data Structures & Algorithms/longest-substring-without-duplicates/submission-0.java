class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> mySet = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++) {
            if (!mySet.contains(s.charAt(i))) {
                mySet.add(s.charAt(i));
                max = Math.max(max, mySet.size());
            } else {
                //duplicate found, reset mySet
                mySet.clear();
                mySet.add(s.charAt(i));
            }
        }
        return max;
    }
}
