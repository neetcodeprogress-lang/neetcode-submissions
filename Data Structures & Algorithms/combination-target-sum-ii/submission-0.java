class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> miniList = new ArrayList<>();
        backtrack(candidates, target, 0, 0, miniList, resultList);
        return resultList;
    }

    public void backtrack(int[] nums, int target, int i, int sum, 
    List<Integer> miniList,
    List<List<Integer>> resultList) {

        //base cases
        //if sum == target add to result list
        if(sum == target) {
            resultList.add(new ArrayList(miniList));
            return;
        }
        //if sum > target return or i >= length
        if(sum > target || i > nums.length - 1) {
            return;
        }

        //include
        miniList.add(nums[i]);
        backtrack(nums, target, i + 1, sum + nums[i], miniList, resultList);
        miniList.remove(miniList.size() - 1);


        //while i equals neighbor
            //i++
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, target, i + 1, sum, miniList, resultList);        

    }
}
