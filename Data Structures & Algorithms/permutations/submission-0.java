class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        //base case: empty array permutates into inself
        if(nums.length == 0) return new List<ArrayList<Integer>>();

        //recursion: assign return to variable
        List<List<Integer>> myList = permute(nums);

        //create array to return
        ArrayList<Integer> resultList = new ArrayList();

        //for each item in myList
        for(List<Integer> i : myList) {
            //for i = 0 to length of item + 1
            for(int i = 0; i <= myList.size(); i++) {

                //create copy cuz we don't want to 
                //modify th eoriginal
                ArrayList<Integer> copy = new ArrayList(i);

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
