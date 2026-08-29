class Solution {
    int rows = 0, cols = 0;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        int totalFruits = 0, rottenFruits = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) { totalFruits++; }
                if(grid[i][j] == 2) {
                    rottenFruits++;
                    queue.add(new int[]{i, j});
                }
            }
        }

        // bfs
        int minute = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            boolean isRot = false;

            while(len != 0) {
                int[] position = queue.remove();
                for(int[] direction: directions) {
                    int xVal = position[0]+direction[0];
                    int yVal = position[1]+direction[1];
                    if(validateBoundary(xVal, yVal, grid)) {
                        queue.add(new int[]{xVal, yVal});
                        rottenFruits++;
                        isRot = true;
                        grid[xVal][yVal] = 2;
                    }
                }
                len--;
            }
            if(isRot) {
                minute++;
            }
        }

        return (totalFruits == rottenFruits) ? minute : -1;
    }

    public boolean validateBoundary(int xVal, int yVal, int[][] grid) {
        return (
            (xVal >= 0 && xVal < rows) && 
            (yVal >= 0 && yVal < cols) &&
            grid[xVal][yVal] == 1
        );
    }
}
