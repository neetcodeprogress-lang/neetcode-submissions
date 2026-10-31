class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == '1') {
                    dfs(grid, i, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        //check north, south east west
        
        grid[r][c] = '0';
        if(r > 0 && grid[r-1][c] == '1') {
            //check north
            dfs(grid, r-1, c);
        }
        if(r < grid.length - 1 && grid[r+1][c] == '1') {
            //check south
            dfs(grid, r+1, c);
        }
        if(c > 0 && grid[r][c-1] == '1') {
            //check west
            dfs(grid, r, c-1);
        }
        if(c < grid[0].length - 1 && grid[r][c+1] == '1') {
            //check east
            dfs(grid, r, c+1);
        }

    }
}
