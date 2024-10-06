import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int p = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    p = bfs(i, j, grid);
                    break;
                }
            }
        }
        return p;
    }

    private int bfs(int start_row, int start_col, int[][] grid) {
        int p = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_row, start_col});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            if (grid[pos[0]][pos[1]] != 1) {
                continue;
            }
            grid[pos[0]][pos[1]] = 2;
            for (int d = 0; d < dirs.length; d++) {
                int new_row = pos[0] + dirs[d][0];
                int new_col = pos[1] + dirs[d][1];
                if (new_row >= rows || new_row < 0 
                    || new_col >= cols || new_col < 0
                    || grid[new_row][new_col] == 0
                ) {
                    p++;
                    continue;
                }
                if (grid[new_row][new_col] == 1) {
                    q.offer(new int[]{new_row,new_col});
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[][] grid = {{1,1},{1,1}};
        Solution sol = new Solution();
        int expOutput = 8;
        int output = sol.islandPerimeter(grid);
        boolean passed = expOutput == output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}