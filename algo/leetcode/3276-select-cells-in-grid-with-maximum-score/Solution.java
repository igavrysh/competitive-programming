import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] values = new int[rows*cols][3];
        for (int i = 0; i < rows; i++) {
            List<Integer> row = grid.get(i);
            for (int j = 0; j < cols; j++) {
                values[i*cols+j] = new int[]{row.get(j), i, j};
            }
        }
        Arrays.sort(values, (int[] v1, int[] v2) -> -1*Integer.compare(v1[0],v2[0]));
        int[] dp = new int[rows*cols];
        boolean[][] state = new boolean[rows*cols][rows];
        int max_score = 0;
        for (int i = 0; i < values.length; i++) {
            int[] vls = values[i];
            for (int j = i-1; j >= -1; j--) {
                if (j == -1 && dp[i] < vls[0]) {
                    state[i][vls[1]] = true;
                    dp[i] = vls[0];
                    max_score = Math.max(max_score, dp[i]);
                }
                if (j == -1) {
                    continue;
                }
                if (state[j][vls[1]] == false && values[j][0] > vls[0] && dp[i] < dp[j]+vls[0]) {
                    for (int k = 0; k < rows; k++) {
                        state[i][k] = state[j][k];
                    }
                    state[i][vls[1]] = true;
                    dp[i] = dp[j] + vls[0];
                    max_score = Math.max(max_score, dp[i]);
                }
            }
        }
        return max_score;
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