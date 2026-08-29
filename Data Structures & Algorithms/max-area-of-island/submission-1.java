class Solution {
    int rows = 0, cols = 0;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        fillVisited2D(grid, visited);
        int maxArea = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(visited[i][j] == -1) {
                    maxArea = Math.max(maxArea, dfs(visited, i, j, directions));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] visited, int x, int y, int[][] directions){
        visited[x][y] = 0;
        int area = 1;

        for(int[] direction: directions) {
            int xVal = x+direction[0];
            int yVal = y+direction[1];
            if(validateBoundary(xVal, yVal)) {
                if(visited[xVal][yVal] == -1) {
                    area += dfs(visited, xVal, yVal, directions);
                }
            }
        }
        return area;
    }

    public boolean validateBoundary(int xVal, int yVal) {
        return (
            (xVal >= 0 && xVal < rows) &&
            (yVal >= 0 && yVal < cols)
        );
    }

    public void fillVisited2D(int[][] grid, int[][] visited){
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = -1;
                }
            }
        }
    }
}
