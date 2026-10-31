class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //keep max count variable
        int maxCount = 0;
        //iterate through the grid
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == 1) {
                    int localCount = dfs(grid, i, n, 0);
                    if(localCount > maxCount) maxCount = localCount;
                }
            }
        }
        //return maxCount
        return maxCount;
    }

    private int dfs(int[][] grid, int row, int col, int count) {
        grid[row][col] = 0;
        //check n, s, e, w
        int left = 0;
        int right = 0;
        int down = 0;
        int up = 0;
        if(row > 0 && grid[row-1][col] == 1) {
            up += dfs(grid, row-1, col, count);
        }
        if(row < grid.length - 1 && grid[row+1][col] == 1) {
            down += dfs(grid, row+1, col, count);
        }
        if(col < grid[0].length - 1 && grid[row][col+1] == 1) {
            right += dfs(grid, row, col+1, count);
        }
        if(col > 0 && grid[row][col-1] == 1) {
            left += dfs(grid, row, col-1, count);
        }
        
        return 1 + left + right + up + down;
    }
}
