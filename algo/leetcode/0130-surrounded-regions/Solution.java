class Solution {
    public void solve(char[][] board) {
        int rows = board.length; int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);
            dfs(i, cols-1, board);
        }

        for (int j = 1; j < cols-1; j++) {
            dfs(0, j, board);
            dfs(rows-1, j, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int row, int col, char[][] board) {
        int rows = board.length; int cols = board[0].length;
        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'P';
        for (int d = 0; d < dirs.length; d++) {
            int newRow = row + dirs[d][0];
            int newCol = col + dirs[d][1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                dfs(newRow, newCol, board);
            }
        }
    }


}