class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        
        1 2 3 4 5       target = 9

        l r

        l   r
        l     r
        l       r
          l r
          l   r
          l     r
            l  r
            l    r
              l  r  FOUND
        */
        int [] myIndices = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            for(int n = i + 1; n < numbers.length; n++ ) {
                if (numbers[i] + numbers[n] == target) {
                    myIndices[0] = i + 1;
                    myIndices[1] = n + 1;
                    break;
                }   
            }   
        }
        
        return myIndices;
    }
}
