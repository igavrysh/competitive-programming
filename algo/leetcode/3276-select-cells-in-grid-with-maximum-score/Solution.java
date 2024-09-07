import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    private int bt(int i, int mask, int sum, int[][] values, int[][] dp) {
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int curr_sum = sum+values[i][0];
        int max = curr_sum;
        state[values[i][1]] = true;
        for (int j = i-1; j>=0; j--) {
            // values[j][0] - value itself, ...[1] row, [2] column
            if (values[j][0] > values[i][0] && state[values[j][1]] == false) {
                max = Math.max(max, bt(j, state, curr_sum, values, dp));
            }
        }
        state[values[i][1]] = false;
        dp[i][state_idx] = max;
        return max;
    }
    public int maxScore(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] dp = new int[100][1024];


        
        int[][] values = new int[rows*cols][3];
        for (int i = 0; i < rows; i++) {
            List<Integer> row = grid.get(i);
            for (int j = 0; j < cols; j++) {
                values[i*cols+j] = new int[]{row.get(j), i, j};
            }
        }
        Arrays.sort(values, (int[] v1, int[] v2) -> -1*Integer.compare(v1[0],v2[0]));
        boolean[] state = new boolean[rows];
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            max = Math.max(max, bt(i, state, 0, values, dp));
        }
        return max;
    }
    public static void main(String[] args) {
        test503();
        test1();
    }
    public static void test1() {
        int[][] grid_simple = {{1,2,3},{4,3,2},{1,1,1}};
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < grid_simple.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid_simple[0].length; j++) {
                row.add(grid_simple[i][j]);
            }
            grid.add(row);
        }
        int exp_output = 8;
        Solution sol = new Solution();
        int output = sol.maxScore(grid);
        boolean passed = output == exp_output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
    public static void test503() {
        int[][] grid_simple = {{6,16},{16,16},{20,20},{20,9}};
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < grid_simple.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid_simple[0].length; j++) {
                row.add(grid_simple[i][j]);
            }
            grid.add(row);
        }
        int exp_output = 51;
        Solution sol = new Solution();
        int output = sol.maxScore(grid);
        boolean passed = output == exp_output;
        System.out.println("test503: " + (passed ? "passed" : "failed"));
    }
}