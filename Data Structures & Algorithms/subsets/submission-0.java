class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //create result list
        List<List<Integer>> resultList = new ArrayList();
        //create mini list that will reset for every mini list
        List<Integer> miniList = new ArrayList();
        //send original array, initial number, mini list, and result list to recursion / backtracking method
        backtrack(nums, 0, miniList, resultList);
        //return the result list
        return resultList;
    }

    //create backtracking method
    public void backtrack(int[] nums, int i , List<Integer> miniSet, List<List<Integer>> resultList) {
        //if i out of bounds
        if(i >= nums.length) {
            //add to resultList
            resultList.add(new ArrayList(miniSet));    
            //return / go back to subsets emthod
            return;
        }        
        //otherwise proceed
        //include nums[i]
        miniSet.add(nums[i]);
        //add to subset
        backtrack(nums, i + 1, miniSet, resultList);

        //exclude nums[i]
        //pop
        miniSet.remove(miniSet.size() - 1);
        //backtrack with i + 1
        backtrack(nums, i + 1, miniSet, resultList);
    }
}
