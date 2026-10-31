class Solution {
    public List<List<String>> partition(String s) {
        //make a path for every char in s
        //create List<List<String>> res
        List<List<String>> res = new ArrayList();
        //create List<String> mini
        List<String> mini = new ArrayList();
        //backtrack(0, s, mini, res)
        backtrack(0,0,s,mini,res);
        //return res
        return res;
    }

    public void backtrack(int i, int j, String s, List<String> mini, List<List<String>> res) {
        //base case
        if(j >= s.length()) {
            //add to res and return
            if(i == j) res.add(new ArrayList(mini));
            return;
        }

        if(isPalindrome(s, i, j)) {
            //add
            mini.add(s.substring(i, j + 1));
            //recursion
            backtrack(j + 1, j + 1, s, mini, res);
            //remove
            mini.remove(mini.size() - 1);
        }

        backtrack(i, j + 1, s, mini, res);

        
    }

    public boolean isPalindrome(String s, int l, int r) {
        
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            r--;
            l++;
        }
        
        return true;
    }
}
