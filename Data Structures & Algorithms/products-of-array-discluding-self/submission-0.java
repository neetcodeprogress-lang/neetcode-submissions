class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tempProduct = 1; //default one 
        int [] myArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++)  {
            for (int n = 0; n < nums.length; n++) {
                if (n != i)
                    tempProduct *= nums[n];
            }
            myArray[i] = tempProduct;
            tempProduct = 1; //reset
        }

        return myArray;
    }
}  
