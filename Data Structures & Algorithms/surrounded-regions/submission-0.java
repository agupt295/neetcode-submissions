class Solution {
    int rows = 0, cols = 0;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        int[][] directions = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        // first row
        for(int col = 0; col < cols; col++) {
            char ch = board[0][col];
            if(ch == 'O') {
                dfs(board, 0, col, directions);
            }
        }

        // last row
        for(int col = 0; col < cols; col++) {
            char ch = board[rows-1][col];
            if(ch == 'O') {
                dfs(board, rows-1, col, directions);
            }
        }

        // first column
        for(int row = 0; row < rows; row++) {
            char ch = board[row][0];
            if(ch == 'O') {
                dfs(board, row, 0, directions);
            }
        }

        // lasy colums
        for(int row = 0; row < rows; row++) {
            char ch = board[row][cols-1];
            if(ch == 'O') {
                dfs(board, row, cols-1, directions);
            }
        }
        fill2DMatrix(board);
    }

    public void dfs(char[][] board, int x, int y, int[][] directions) {
        board[x][y] = '#';
        for(int[] direction: directions) {
            int xVal = x+direction[0];
            int yVal = y+direction[1];
            if(validateBoundary(xVal, yVal, board)) {
                dfs(board, xVal, yVal, directions);
            }
        }
    }

    public boolean validateBoundary(int xVal, int yVal, char[][] board) {
        return (
            (xVal >= 0 && xVal < rows) &&
            (yVal >= 0 && yVal < cols) &&
            (board[xVal][yVal] == 'O')
        );
    }

    public void fill2DMatrix(char[][] board){
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
