class Solution {
    int rows = 0, cols = 0;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        fillVisited2D(grid, visited);
        int islandsCount = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(visited[i][j] == -1) {
                    islandsCount++;
                    dfs(visited, i, j, directions);
                }
            }
        }
        return islandsCount;
    }

    public void dfs(int[][] visited, int x, int y, int[][] directions) {
        visited[x][y] = 0;
        for(int[] direction: directions) {
            int xValue = x+direction[0];
            int yValue = y+direction[1];
            if(validBoundary(xValue, yValue)) {
                if(visited[xValue][yValue] == -1) {
                    dfs(visited, xValue, yValue, directions);
                }
            }
        }
    }

    public boolean validBoundary(int xValue, int yValue) {
        return (
            (xValue >= 0 && xValue < rows) &&
            (yValue >= 0 && yValue < cols)
        );
    }

    public void fillVisited2D(char[][] grid, int[][] visited) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') { visited[i][j] = -1; }
            }
        }
    }
}
