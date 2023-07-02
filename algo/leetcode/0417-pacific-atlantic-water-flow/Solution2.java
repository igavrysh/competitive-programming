import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        byte[] state = new byte[rows*cols];
        List<List<Integer>> acc = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, (byte)1, state, heights, acc);
            dfs(i, cols-1, (byte)2, state, heights, acc);
        }
        for (int j = 0; j < cols; j++) {
            dfs(0, j, (byte)1, state, heights, acc);
            dfs(rows-1, j, (byte)2, state, heights, acc);
        }
        return acc;
    }

    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    private void dfs(int row, int col, byte w, byte[]state, int[][] heights, List<List<Integer>> acc) {
        int rows = heights.length;
        int cols = heights[0].length;
        int idx = row * cols + col;
        if ((state[idx] & w) > 0) {
            return;
        }
        state[idx] += w;
        if (state[idx] == 3) {
            acc.add(Arrays.asList(new Integer[]{row,col}));
        }
        for (int d = 0; d < dirs.length; d++) {
            int newRow = row + dirs[d][0];
            int newCol = col + dirs[d][1];
            if (newRow < rows && newRow >= 0 && newCol < cols && newCol >= 0 
                && heights[row][col] <= heights[newRow][newCol]
            ) {
                dfs(newRow, newCol, w, state, heights, acc);
            }
        }
    }

    public static void main(String[] args) {
        testSolution2_1();
    }

    public static void testSolution2_1() {
        int[][] heights = new int[][] {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        Solution2 s = new Solution2();
        List<List<Integer>> res = s.pacificAtlantic(heights);
        Integer[][] exp = new Integer[][] {
            {0,4},{1,3},{1,4},{2,2},{3,0},{3,1},{4,0}
        };
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            hs.add(res.get(i).get(0) + "_" + res.get(i).get(1));
        }
        HashSet<String> expHs = new HashSet<>();
        for (int i = 0; i < exp.length; i++) {
            expHs.add(exp[i][0] + "_" + exp[i][1]);
        }
        boolean passed = res.size() == expHs.size() && hs.size() == expHs.size() && hs.equals(expHs);
        System.out.println("testSolution2_1: " + (passed ? "passed" : "failed"));
    }
}
