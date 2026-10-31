class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // create list<list<integer>> validPoints
        List<List<Integer>> validPoints = new ArrayList<>();
        // hashset<int[]> pacific
        HashSet<List<Integer>> pacific = new HashSet<>();
        // hashset<int[]> atlantic
        HashSet<List<Integer>> atlantic = new HashSet<>();
        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, pacific);
            dfs(heights, row, heights[0].length-1, atlantic);
        }
        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, pacific);
            
            dfs(heights, heights.length - 1, col, atlantic);
        }

        for (List<Integer> point : pacific) {
            if (atlantic.contains(point)) {
                validPoints.add(point);
            }
        }
        // return the list of valid points
        return validPoints;
    }

    public void dfs(int[][] heights, int row, int col, 
    HashSet<List<Integer>> valid) {
        valid.add(List.of(row, col));
        int curVal = heights[row][col];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int innerRow = row + direction[0];
            int innerCol = col + direction[1];
            if (innerRow >= 0 && innerRow < heights.length 
                && innerCol >= 0 && innerCol < heights[0].length 
                && heights[innerRow][innerCol] >= curVal
                && !valid.contains(List.of(innerRow, innerCol))) {
                dfs(heights, innerRow, innerCol, valid);
            }
        }
    }
}
