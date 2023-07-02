class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public int dfs(int i, int j, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int counter = 1;
        grid[i][j] = -1; 
        for (int d = 0; d < dirs.length; d++) {
            int nextI = i + dirs[d][0];
            int nextJ = j + dirs[d][1];
            if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && grid[nextI][nextJ] == 1) {
                counter += dfs(nextI, nextJ, grid);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Solution s = new Solution();
        int output = s.maxAreaOfIsland(grid);
        boolean passed = output == 6;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

        public static void test2() {
        int[][] grid = {
            {0,0,0,0,0,0,0,0}
        };
        Solution s = new Solution();
        int output = s.maxAreaOfIsland(grid);
        boolean passed = output == 0;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}