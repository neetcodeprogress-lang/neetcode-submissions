class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits.isEmpty()) return res;

        //create hashmap of number and associated letters
        HashMap<Integer, String> combo = new HashMap();
        StringBuilder mini = new StringBuilder();
        //2-9, abc, def, ghi, jkl, mno, pqrs, tuv, wxyz
        combo.put(2, "abc");
        combo.put(3, "def");
        combo.put(4, "ghi");
        combo.put(5, "jkl");
        combo.put(6, "mno");
        combo.put(7, "pqrs");
        combo.put(8, "tuv");
        combo.put(9, "wxyz");
        backtrack(digits, combo, mini, res, 0);
        return res;
    }

    public void backtrack(String digits, 
        HashMap<Integer, String> combo,
        StringBuilder mini,
        List<String> res,
        int i
    ) {
        if (i >= digits.length()) {
            res.add(mini.toString());
            return;
        }

        //main backtracking logic

        int size = combo.get(Integer.parseInt(String.valueOf(digits.charAt(i)))).length();

        for(int n = 0; n < size; n++) {

            String temp = combo.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
            mini.append(temp.charAt(n));
            backtrack(digits, combo, mini, res, i + 1);
            mini.deleteCharAt(mini.length() - 1);
        }

    }

}
