class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //create arraydeque
        //go through the grid
        //if is trasure chest, add to arraydquee
        
        //now we have queue of treasure chests
        //create a dir array
        //iterate through
        //if within bounds, check NSEW, and if it's a INF, mark it with the distance to the tresasure
            //enter dfs again; until we are out of bounds or no more traversable land

        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == 0) {
                    queue.add(new int[]{i, n});
                }
            }
        }

        int[][] directions = {{-1, 0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] point = queue.poll();
                int count = grid[point[0]][point[1]];
                for(int[] direction : directions) {
                    int row = point[0] + direction[0];
                    int col = point[1] + direction[1];
                    if(row >= 0 && row < grid.length && col >=0 && col < grid[0].length 
                    && grid[row][col] == Integer.MAX_VALUE){
                        grid[row][col] = count + 1;
                        queue.add(new int[]{row, col});
                    }

                }
            }
        }
    }
}
