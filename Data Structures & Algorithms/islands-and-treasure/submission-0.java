class Solution {
    public void islandsAndTreasure(int[][] grid) {
        List<List<Integer>> queue = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int n = 0; n < grid[0].length; n++) {
                if(grid[i][n] == 0) {
                    //add to queue
                    queue.add(List.of(i, n));
                }
            }
        }

        while(!queue.isEmpty()) {
            List<Integer> temp = queue.remove(0);
            int row = temp.getFirst();
            int col = temp.get(1);
            int count = grid[row][col];
            if(row > 0 && grid[row-1][col] == Integer.MAX_VALUE) {
                grid[row-1][col] = count + 1;
                queue.addLast(List.of(row-1, col));
            }
            if(row < grid.length - 1 && grid[row+1][col] == Integer.MAX_VALUE) {
                grid[row+1][col] = count + 1;
                queue.addLast(List.of(row+1, col));
            }
            if(col > 0 && grid[row][col-1] == Integer.MAX_VALUE) {
                grid[row][col-1] = count + 1;
                queue.addLast(List.of(row, col-1));
            }
            if(col < grid[0].length - 1 && grid[row][col+1] == Integer.MAX_VALUE) {
                grid[row][col+1] = count + 1;
                queue.addLast(List.of(row, col+1));
            }
        }
    }
}
