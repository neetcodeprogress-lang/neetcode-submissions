class Solution {
    public int characterReplacement(String s, int k) {
        //set l and r to 0
        int l = 0;
        int r = 0;
        int count = 0; //represents count of letters we can replace in our window
        int globalMax = 0;
        while (r < s.length()) {
        //while r < s.length()
            //if r is same as l increment r
            if (s.charAt(r) == s.charAt(l)) {
                r++;
            } else {
            //if not, set count++
                count++;
                r++;
            }
            //if count == k, that's the amount that we can change 
            if(count == k) {
                globalMax = Math.max(globalMax, r - l + 1);
                count = 0;
                l = r;
            }
                    //set global max to length of window(r - l)
                    //reset count
                    //move l to r
                //if count > k
                    //window too big; ideally should not get here
                //if count < k
                    //keep incrementing r
        }
        return globalMax;
    }
}
