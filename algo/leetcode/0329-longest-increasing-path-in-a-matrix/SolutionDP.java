// Shamelessly stolen solution from leetcode top solutions by time

public class SolutionDP {
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length == 0) return 0;
        
        int m = matrix.length; int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        int max = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                int len = dfs(matrix, i, j, m, n, dp);
                max = Math.max(max, len);
                
            }
        }   
        
        return max;
    }
    
    public int dfs(int[][] matrix, int x, int y, int m, int n, int[][] dp) {
        
        if(dp[x][y] != 0) return dp[x][y];
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int max = 1;
        
        for(int[] dir: dirs) {
            
            int nx = x + dir[0], ny = y + dir[1];
            
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(matrix[nx][ny] <= matrix[x][y]) continue;
      
            max = Math.max(max, 1 + dfs(matrix, nx, ny, m, n, dp));
        }
        
        dp[x][y] = max;
        
        return max;
    }
}
