import java.util.HashSet;

class SolutionSimple {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] islandMap = new int[n][n];
        int[] sizes = new int[n*n+1];
        int id = 1;
        int maxSize = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && islandMap[row][col] == 0) {
                    dfs(row, col, id++, grid, islandMap, sizes);
                    maxSize = Math.max(maxSize, sizes[id-1]);
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int currSize = 0;
                    HashSet<Integer> ids = new HashSet<>();
                    for (int d = 0; d < dirs.length; d++) {
                        int nextRow = row + dirs[d][0];
                        int nextCol = col + dirs[d][1];
                        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                            int islandId = islandMap[nextRow][nextCol];
                            if (islandId != 0 && !ids.contains(islandId)) {
                                ids.add(islandId);
                                currSize += sizes[islandId];
                            } 
                        }
                    }
                    currSize += 1;
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        return maxSize;
    }

    public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int row, int col, int id, int[][] grid, int[][] islandMap, 
        int[] sizes
    ) {
        sizes[id] = sizes[id]+1;
        islandMap[row][col] = id;
        int n = grid.length;
        for (int d = 0; d < dirs.length; d++) {
            int nextRow = row + dirs[d][0];
            int nextCol = col + dirs[d][1];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                && grid[nextRow][nextCol] == 1 && islandMap[nextRow][nextCol] == 0
            ) {
                dfs(nextRow, nextCol, id, grid, islandMap, sizes);
            }
        }
    }

     public static void main(String[] args) {
        testSolutionSimple_1();
        testSolutionSimple_2();
        testSolutionSimple_3();
    }

    public static void testSolutionSimple_1() {
        int[][] grid = {{1,0},{0,1}};
        SolutionSimple s = new SolutionSimple();
        int output = s.largestIsland(grid);
        boolean passed = output == 3;
        System.out.println("testSolutionSimple_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSimple_2() {
        int[][] grid = {{1,1},{0,1}};
        SolutionSimple s = new SolutionSimple();
        int output = s.largestIsland(grid);
        boolean passed = output == 4;
        System.out.println("testSolutionSimple_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSimple_3() {
        int[][] grid = {{1,1},{1,1}};
        SolutionSimple s = new SolutionSimple();
        int output = s.largestIsland(grid);
        boolean passed = output == 4;
        System.out.println("testSolutionSimple_3: " + (passed ? "passed" : "failed"));
    }
}