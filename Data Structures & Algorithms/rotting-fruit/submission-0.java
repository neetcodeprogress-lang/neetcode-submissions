class Solution {
    public int orangesRotting(int[][] grid) {
        //find the location of the rotten fruit
        //int freshFruit
        //int minute
        //add to queue
        //then iterate through the queue
        //check horizontal and vertical neighbors
            //if they are a one, 
                //turn it to a 2
                //increment minute and pass in 
                //add that point into the queue

        //return freshFruit == 0 ? minutes : -1


        Deque<int[]> queue = new ArrayDeque<>();
        int freshFruit = 0;
        int minutes = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == 2) {
                    queue.offer(new int[]{i, n});
                }
                if(grid[i][n] == 1) {
                    freshFruit += 1;
                }
            }
        }

        int[][] directions = new int[][]{{0, 1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty() && freshFruit > 0) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] point = queue.poll();
                for(int[] direction : directions) {
                    int row = point[0] + direction[0];
                    int col = point[1] + direction[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length 
                    && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        freshFruit--;
                    }
                }
                
                // if(row > 0 && grid[row-1][col] == 1) {
                //     grid[row-1][col] = 2;
                //     queue.offer(new int[]{row-1, col});
                //     freshFruit--;
                // }
                // if(row < grid.length - 1 && grid[row+1][col] == 1) {
                //     grid[row+1][col] = 2;
                //     queue.offer(new int[]{row+1, col});
                //     freshFruit--;
                // }
                // if(col < grid[0].length - 1 && grid[row][col+1] == 1) {
                //     grid[row][col+1] = 2;
                //     queue.offer(new int[]{row, col+1});
                //     freshFruit--;
                // }
                // if(col > 0 && grid[row][col-1] == 1) {
                //     grid[row][col-1] = 2;
                //     queue.offer(new int[]{row, col-1});
                //     freshFruit--;
                // }
            }
            minutes += 1;
        }

        return freshFruit == 0 ? minutes : -1;
    }
}
