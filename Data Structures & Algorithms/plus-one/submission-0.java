class Solution {
    public int[] plusOne(int[] digits) {
        String integerRep = "";
        for(int i : digits) {
            integerRep += i;
        }
        int val = Integer.valueOf(integerRep);

        val += 1;
        int[] myArray = new int[String.valueOf(val).length()];
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = String.valueOf(val).charAt(i) - 48;
        }

        return myArray;
    }
}
