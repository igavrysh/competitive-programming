import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] islandMap = new int[rows][cols];
        List<Integer> sizes = new ArrayList<Integer>();
        int id = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col, id++, grid, islandMap, sizes);
                }
            }
        }

        int maxSize = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    int currSize = 0;
                    HashSet<Integer> ids = new HashSet<>();
                    for (int d = 0; d < dirs.length; d++) {
                        int nextRow = row + dirs[d][0];
                        int nextCol = col + dirs[d][1];
                        if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                            int islandId = islandMap[nextRow][nextCol];
                            if (islandId != 0 && !ids.contains(islandId)) {
                                ids.add(islandId);
                                currSize += sizes.get(islandId);
                            } 
                        }
                    }
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        
        return maxSize;

    }

    public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int row, int col, int id, int[][] grid, int[][] islandMap, 
        List<Integer> sizes
    ) {
        if (sizes.size() == id) {
            sizes.add(id, 1);
        } else {
            sizes.set(id, sizes.get(id)+1);
        }
        islandMap[row][col] = id;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int d = 0; d < dirs.length; d++) {
            int nextRow = row + dirs[d][0];
            int nextCol = col + dirs[d][1];
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                && grid[nextRow][nextCol] == 1 && islandMap[nextRow][nextCol] == 0
            ) {
                dfs(nextRow, nextCol, id, grid, islandMap, sizes);
            }
        }
    }
}