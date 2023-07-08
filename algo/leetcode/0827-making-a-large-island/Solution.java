class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] sizes = new int[n*n+2];
        int id = 2;
        int maxSize = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col, id++, grid, sizes);
                    maxSize = Math.max(maxSize, sizes[id-1]);
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int currSize = 0;

                    int l = col-1>=0 ? grid[row][col-1] : 0;
                    int r = col+1<n ? grid[row][col+1] : 0;
                    int u = row-1>=0 ? grid[row-1][col] : 0;
                    int d = row+1<n ? grid[row+1][col] : 0;

                    currSize += sizes[l]; 
                    if (r != l) currSize += sizes[r];
                    if (u != l && u != r) currSize += sizes[u];
                    if (d != l && d != r && d != u) currSize += sizes[d];

                    currSize += 1;
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        return maxSize;
    }

    public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int row, int col, int id, int[][] grid, int[] sizes) {
        sizes[id] = sizes[id]+1;
        grid[row][col] = id;
        for (int d = 0; d < dirs.length; d++) {
            int nextRow = row + dirs[d][0];
            int nextCol = col + dirs[d][1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid.length
                && grid[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, id, grid, sizes);
            }
        }
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        int[][] grid = {{1,0},{0,1}};
        Solution s = new Solution();
        int output = s.largestIsland(grid);
        boolean passed = output == 3;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[][] grid = {{1,1},{0,1}};
        Solution s = new Solution();
        int output = s.largestIsland(grid);
        boolean passed = output == 4;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int[][] grid = {{1,1},{1,1}};
        Solution s = new Solution();
        int output = s.largestIsland(grid);
        boolean passed = output == 4;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
}