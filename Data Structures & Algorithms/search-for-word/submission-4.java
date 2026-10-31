class Solution {
    public boolean exist(char[][] board, String word) {
        
        // create hashset
        HashSet<List<Integer>> set = new HashSet();
        ArrayList<Integer> list = new ArrayList(Arrays.asList(0, 0));
        boolean boo = false;
        for (int i = 0; i < board.length; i++) {
            for (int n = 0; n < board[i].length; n++) {
                if (board[i][n] == word.charAt(0)) {
                    if(word.length() == 1) return true; // account for 1 letter words
                    set.add(Arrays.asList(i, n));
                    boo = backtrack(board, word, 1, set, list, i, n);
                    if (boo) {
                        return true;
                    }
                    set.remove(Arrays.asList(i, n));
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, HashSet<List<Integer>> mySet,
        List<Integer> list, int i, int n) {
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        // check up
        if (i > 0) {
            if (board[i - 1][n] == word.charAt(index) && !mySet.contains(Arrays.asList(i - 1, n))) {
                if(index == word.length() - 1) return true;
                mySet.add(Arrays.asList(i - 1, n));
                up = backtrack(board, word, index + 1, mySet, list, i - 1, n);
                mySet.remove(Arrays.asList(i-1, n));
                if(up) return up;
            }
        }
        // check down
        if (i < board.length - 1) {
            if (board[i + 1][n] == word.charAt(index) && !mySet.contains(Arrays.asList(i + 1, n))) {
                if(index == word.length() - 1) return true;
                mySet.add(Arrays.asList(i + 1, n));
                down = backtrack(board, word, index + 1, mySet, list, i + 1, n);
                mySet.remove(Arrays.asList(i+1, n));
                if(down) return down;
            }
        }
        // check left
        if (n > 0) {
            if (board[i][n - 1] == word.charAt(index) && !mySet.contains(Arrays.asList(i, n - 1))) {
                if(index == word.length() - 1) return true;
                mySet.add(Arrays.asList(i, n - 1));
                left = backtrack(board, word, index + 1, mySet, list, i, n - 1);
                mySet.remove(Arrays.asList(i, n - 1));
                if(left) return left;
            }
        }
        // check right
        if (n < board[i].length - 1) {
            if (board[i][n + 1] == word.charAt(index) && !mySet.contains(Arrays.asList(i, n + 1))) {
                if(index == word.length() - 1) return true;
                mySet.add(Arrays.asList(i, n + 1));
                right = backtrack(board, word, index + 1, mySet, list, i, n + 1);
                mySet.remove(Arrays.asList(i, n + 1));
                if(right) return right;
            }
        }
        
        //nothing returned true, so must be false
        return false;
    }
}
