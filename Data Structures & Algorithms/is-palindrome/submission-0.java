class Solution {
    public boolean isPalindrome(String s) {
        //left = 0
        //right = s.length()
        //myBoolean = true;

        boolean myBoolean = true;

        String myString = "";
        //iterate through array, remove all non-alphanumeric characters
        for(char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // is non-alphanumeric
                myString += c;
            }
        }

        myString = myString.toLowerCase();

        //now have an array with just a-z
        //so we use pointers to compare the string
        //if left > right we have passed the middle
        //but otherwise compare left and right 
            //if same increment left, decrement right
            //if not same return myBoolean(false)
        int left = 0;
        int right = myString.length() - 1;
        while (left < right) {
            if (!(myString.charAt(left) == myString.charAt(right))) {
                myBoolean = false;
            } 
            left++;
            right--;
        } //tabacat

        return myBoolean;

    }
}
