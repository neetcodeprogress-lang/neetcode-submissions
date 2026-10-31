class Solution {
    public boolean isAnagram(String s, String t) {
        //first compare lengths
        //if they are the same, sort them out, and compare each char?

        if (s.length() != t.length()) {
            return false;
        } else {
            char [] sCharArray= s.toCharArray();
            char [] tCharArray= t.toCharArray();

            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);

            for (int i = 0; i < sCharArray.length; i++) {
                if (sCharArray[i] != tCharArray[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
