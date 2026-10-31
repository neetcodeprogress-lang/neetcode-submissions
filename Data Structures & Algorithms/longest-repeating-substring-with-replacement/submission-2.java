class Solution {
    public int characterReplacement(String s, int k) {
        //set l and r to 0
        int l = 0;
        int r = 0;
        int count = 0; //count of char inside of the window
        int globalMax = 0;

        HashSet<Character> mySet = new HashSet<>();
        for(char c : s.toCharArray()) {
            mySet.add(c);
        }
        
        // add chars of string to set called mySet
        // for each char in the set mySet
        //     set l = 0;
        //     set r = 0
        //     set count = 0
        for(Character c : mySet) {
            r = 0;
            count = 0;
            l = 0;
            while (r < s.length()) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if(s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }
                
                globalMax = Math.max(globalMax, r - l + 1);
                r++;
            }
        }
        return globalMax;
    }
}
