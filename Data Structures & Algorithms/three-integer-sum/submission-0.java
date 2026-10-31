class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //can use the same number only once

        //sort?                      i         n     k
        // [-1, 0, 1, 2, -1, 4] -> [-1, -1, 0, 1, 2, 4] 

        //rather than compare each index by another,
        //nested for loop, outer is i, inner checks j and k
            //if j + k == (-)i -> adds to zero, add to List
            //else -> increment k
        List<List<Integer>> myList = new ArrayList<List<Integer>>();
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            for(int n = i + 1; n < nums.length; n++) {
                k = n + 1;
                while(k < nums.length) {
                    if (nums[i] + nums[n] + nums[k] == 0) {
                        List<Integer> newList = new ArrayList<Integer>();
                        newList.add(nums[i]);
                        newList.add(nums[n]);
                        newList.add(nums[k]);
                        Collections.sort(newList);
                        if (!myList.contains(newList)) {
                            myList.add(newList);
                            // i++;
                        }

                    }
                    k++;
                }
            }
        }

        return myList;
    }
}
