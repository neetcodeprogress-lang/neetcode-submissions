class Solution {
    public List<String> generateParenthesis(int n) {
        //()() and (())

        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int numOpen = 0;
        int numClose = 0;
        //numOpen, numClose, n, sb, res
        backtrack(numOpen, numClose, n, sb, res);
        return res;
    }

    public void backtrack(int numOpen, int numClose, int n, StringBuilder sb, List<String> res) {
        if(numOpen == numClose && numClose == n) {
            //add to res
            res.add(sb.toString());
            return;
        }

        //else; add 
        if(numOpen < n) {
            //still enough open parenthesis that we can add
            sb.append('(');
            backtrack(numOpen + 1, numClose, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(numClose < numOpen) {
            sb.append(')');
            backtrack(numOpen, numClose + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
