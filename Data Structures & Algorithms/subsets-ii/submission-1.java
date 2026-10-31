class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort nums so that duplicates are closer together
        Arrays.sort(nums);
        //if there is a duplicate, just increment i until we
        //not on a duplicate anymore
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList();
        //then pass to backtrack method
        //backtrack(array, index, subset, resultList)
        backtrack(nums, 0, subset, res);
        return res;
    }

    //public void backtrack(array nums, index, subset, resultList)
    public void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        //base case: i >= nums.length
        if(i >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }
        
        //logic
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);

        //if duplicate set i to a non duplicate
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        backtrack(nums, i + 1, subset, res);

    }
}
