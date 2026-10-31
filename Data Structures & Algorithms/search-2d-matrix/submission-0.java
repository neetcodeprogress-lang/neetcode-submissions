class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        ArrayList<Integer> myList = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int n = 0; n < matrix[i].length; n++) {
                myList.add(matrix[i][n]);
            }
        }

        int l = 0;
        int r = myList.size() - 1;
        int m = 0;
        while (l <= r) {
            m = (r+l)/ 2;
            if (myList.get(m) == target) {
                return true;
            } else if (myList.get(m) < target) {
                l = m+1;
            } else if (myList.get(m) > target){
                r = m-1;
            }
        }

        return false;
    }
}
