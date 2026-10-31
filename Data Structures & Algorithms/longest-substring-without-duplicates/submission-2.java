class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;
        int max = 0;
        HashSet<Character> mySet = new HashSet<>();

        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        mySet.add(s.charAt(left));

        while(right < s.length()) {
            if (!mySet.contains(s.charAt(right))) {
                mySet.add(s.charAt(right));
                max = Math.max(max, mySet.size());
                right++;
            } else {
                max = Math.max(max, 1);
                mySet.clear();
                left++;
                right = left + 1;
                mySet.add(s.charAt(left));
            }
        }

        return max;
    }
}
