class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> miniList = new ArrayList<>();
        backtrack(nums, target, miniList, 0, resultList);
        return resultList;
    }

    //backtrack method
    public void backtrack(int[] nums, int target, 
    List<Integer> miniList, 
    int i,
    List<List<Integer>> resultList) {

        //base case: If target == 0, found one sum / solution
        if(target == 0) {
            resultList.add(new ArrayList<>(miniList));
            return;
        }
        //base case: if target < 0 or i >= length, not a solution
        if(target < 0 || i >= nums.length) {
            return;
        }

        //logic: include
        miniList.add(nums[i]);
        backtrack(nums, target - nums[i], miniList, i, resultList);

        //logic: exclude
        miniList.remove(miniList.size() - 1);
        backtrack(nums, target, miniList, i + 1, resultList);
    }
}
