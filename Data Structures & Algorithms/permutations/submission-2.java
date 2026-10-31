class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        //base case: empty array permutates into inself
        List<List<Integer>> emptyList = new ArrayList<>();
        if(nums.length == 0) {
            emptyList.add(new ArrayList<>());
            return emptyList;
        }

        //recursion: assign return to variable
        List<List<Integer>> myList = permute(Arrays.copyOfRange(nums, 1, nums.length));

        //create array to return
        List<List<Integer>> resultList = new ArrayList<>();

        //for each item in myList
        for(List<Integer> list : myList) {
            //for i = 0 to length of item + 1
            for(int i = 0; i <= list.size(); i++) {

                //create copy cuz we don't want to 
                //modify th eoriginal
                List<Integer> copy = new ArrayList<>(list);

                //insert at i nums[0] 
                copy.add(i, nums[0]);
                //append copy to resultList 
                resultList.add(copy);
            }
        }
        //return resultList
        return resultList;
    }
}
