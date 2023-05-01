package com.company;

public class SolutionDFS {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int N = grid.length;
        int M = grid[0].length;

        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != '0') {
                    counter++;
                    DFS(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void DFS(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int k = 0; k < deltas.length; k++) {
            int newI = i + deltas[k][0];
            int newJ = j + deltas[k][1];
            if (newI >= 0
                    && newI < grid.length
                    && newJ >= 0
                    && newJ < grid[0].length) {
                if (grid[newI][newJ] != '0') {
                    DFS(grid, newI, newJ);
                }
            }
        }
    }
}
