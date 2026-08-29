class Solution {
    int rows = 0, cols = 0;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int distance = 0;

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        fillQueue(grid, queue);

        // bfs
        while(!queue.isEmpty()){
            int len = queue.size();
            distance++;
            while(len != 0) {
                int[] position = queue.remove();
                for(int[] direction: directions) {
                    int xVal = position[0]+direction[0];
                    int yVal = position[1]+direction[1];
                    if(validateBoundary(xVal, yVal, grid)) {
                        queue.add(new int[]{xVal, yVal});
                        grid[xVal][yVal] = distance;
                    }
                }
                len--;
            }
        }
    }

    public boolean validateBoundary(int xVal, int yVal, int[][] grid) {
        return (
            (xVal >= 0 && xVal < rows) &&
            (yVal >= 0 && yVal < cols) &&
            (grid[xVal][yVal] == Integer.MAX_VALUE)
        );
    }

    public void fillQueue(int[][] grid, Queue<int[]> queue) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
    }
}
