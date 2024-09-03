import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int levels = Math.min(grid.length, grid[0].length)/2;
        for (int l = 0; l < levels; l++) {
            rotate_level(l, grid, k);
        }
        return grid;
    }
    private static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private void rotate_level(int l, int[][] grid, int k) {
        int s_i = l;
        int s_j = l;
        int p = (grid.length-2*l-1 + grid[0].length-2*l-1)*2;
        k = k % p;
        Queue<Integer> q = new LinkedList<>();
        
        int i = s_i, j = s_j;
        int d_r = 0;
        int d = 0;
        for (int st = 0; st < k; st++) {
            if (st < k) {
                q.offer(grid[i][j]);
            }

            if (!is_valid_next_step(d, i, j, l, grid)) {
                d = (d+1)%dirs.length;
            }
            i = i+dirs[d][0];
            j = j+dirs[d][1];
        }

        for (int st = k; st < p; st++) {
            grid[s_i][s_j] = grid[i][j];

            if (!is_valid_next_step(d, i, j, l, grid)) {
                d = (d+1)%dirs.length;
            }
            i = i+dirs[d][0];
            j = j+dirs[d][1];

            if (!is_valid_next_step(d_r, s_i, s_j, l, grid)) {
                d_r = (d_r+1)%dirs.length;
            }
            s_i = s_i+dirs[d_r][0];
            s_j = s_j+dirs[d_r][1];
        }
            
        for (int st = 0; st < k; st++) { 
            grid[s_i][s_j] = q.poll();

            if (!is_valid_next_step(d_r, s_i, s_j, l, grid)) {
                d_r = (d_r+1)%dirs.length;
            }
            s_i = s_i+dirs[d_r][0];
            s_j = s_j+dirs[d_r][1];
        }
    }
    private boolean is_valid_next_step(int d, int i, int j, int l, int[][] grid) {
        int s_i = l;
        int s_j = l;
        if (i+dirs[d][0] < s_i || i+dirs[d][0] > grid.length-1-l
            || j+dirs[d][1] < s_j || j+dirs[d][1] > grid[0].length-1-l
        ) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }
    private static void test1() {
        int[][] grid = {
            {40,10},
            {30,20}
        };
        int[][] exp_output_grid = {
            {10,20},
            {40,30}
        };
        int k = 1;
        Solution sol = new Solution();
        int[][] output_grid = sol.rotateGrid(grid, k);
        boolean passed = true;
        for (int i = 0; i < exp_output_grid.length; i++) {
            passed = passed & Arrays.equals(output_grid[i], exp_output_grid[i]);
        }
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
    private static void test2() {
        int[][] grid = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int[][] exp_output_grid = {
            {3,4,8,12},
            {2,11,10,16},
            {1,7,6,15},
            {5,9,13,14}
        };
        int k = 2;
        Solution sol = new Solution();
        int[][] output_grid = sol.rotateGrid(grid, k);
        boolean passed = true;
        for (int i = 0; i < exp_output_grid.length; i++) {
            passed = passed & Arrays.equals(output_grid[i], exp_output_grid[i]);
        }
        System.out.println("test2:"+(passed ? "passed" : "failed"));
    }
    private static void test3() {
        int[][] grid = {
            {10,1, 4, 8},
            {6, 6, 3,10},
            {7, 4, 7,10},
            {1,10, 6, 1},
            {2, 1, 1,10},
            {3, 8, 9, 2},
            {7, 1,10,10},
            {7, 1, 4, 9},
            {2, 2, 4, 2},
            {10,7, 5,10}
        };
        int[][] exp_output_grid = {
            {1, 4, 8,10},
            {10,3, 7,10},
            {6, 6, 6, 1},
            {7, 4, 1,10},
            {1,10, 9, 2},
            {2, 1,10,10},
            {3, 8, 4, 9},
            {7, 1, 4, 2},
            {7, 1, 2,10},
            {2,10, 7, 5}
        };
        int k = 1;
        Solution sol = new Solution();
        int[][] output_grid = sol.rotateGrid(grid, k);
        boolean passed = true;
        for (int i = 0; i < exp_output_grid.length; i++) {
            passed = passed & Arrays.equals(output_grid[i], exp_output_grid[i]);
        }
        System.out.println("test3:"+(passed ? "passed" : "failed"));

    }
}