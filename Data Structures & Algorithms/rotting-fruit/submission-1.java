class Solution {
    public int orangesRotting(int[][] grid) {
        //create arraydeque queue
        //create a freshFruit variable
        //create minutes variable
        //iterate through grid
            //if 2, add to queue
            //if 1, increment freshFruit

        //while queue not empty && freshFruit > 0
            //queuesize = queue.size
            //for all in queue at this current state
                //get the point in the queue
                //count = point in grid
                //for each direction in directions
                    //if within bounds, and are fresh fruit
                        //freshFruit--
                        //turn nieghbor into a 2
        
                //minutes++;
        //return freshFruit==0? minutes : -1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freshFruit = 0;
        int minutes = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == 1) {
                    freshFruit++;
                } else if (grid[i][n] == 2) {
                    queue.add(new int[]{i, n});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty() && freshFruit > 0) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] point = queue.poll();
                int count = grid[point[0]][point[1]];
                for(int[] dir : directions) {
                    int row = point[0] + dir[0];
                    int col = point[1] + dir[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length 
                    && grid[row][col] == 1) {
                        freshFruit--;
                        grid[row][col] = 2;
                        queue.add(new int[]{row, col});
                    }
                }
            }
            minutes++;
        }

        return freshFruit == 0 ? minutes : -1;
    }
}
