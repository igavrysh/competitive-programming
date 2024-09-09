import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int maxMoves(int kx, int ky, int[][] pos) {
        int n = pos.length;
        int[][] positions = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            positions[i] = pos[i];
        }
        positions[n] = new int[]{kx,ky};
        int[][] moves = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            min_moves(i, positions, moves);
        }
        int[][] dp = new int[n+1][(int)Math.pow(2,pos.length)];
        dfs(n, 0, dp, 0, moves);
        return dp[n][0];
    }
    private int dfs(int i, int turn, int[][] dp, int mask, int[][] moves) {
        if (turn == moves.length-1) {
            return 0;
        }
        if (dp[i][mask] != 0) {
            return dp[i][mask];
        }
        int[] neighbrs = moves[i];
        dp[i][mask] = turn % 2 == 0 ? 0 : Integer.MAX_VALUE;
        for (int j = 0; j < neighbrs.length-1; j++) {
            if (i==j || neighbrs[j] == 0 || (mask & (1<<j)) != 0) {
                continue;
            }
            dp[i][mask] = turn%2 == 0
                ? Math.max(dp[i][mask], moves[i][j] + dfs(j, turn+1, dp, mask | (1<<j), moves))
                : Math.min(dp[i][mask], moves[i][j] + dfs(j, turn+1, dp, mask | (1<<j), moves));
        }
        return dp[i][mask];
    }
    private static int[][] dirs = {{2,1},{1,2},{2,-1},{1,-2},{-2,1},{-1,2},{-2,-1},{-1,-2}};
    private static int ROWS = 50;
    private static int COLS = 50;
    private void min_moves(int i, int[][] pos, int[][] moves) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{pos[i][0], pos[i][1]});
        int[][] board = new int[ROWS][COLS];
        board[pos[i][0]][pos[i][1]] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < dirs.length; d++) {
                int next_x = curr[0] + dirs[d][0];
                int next_y = curr[1] + dirs[d][1];
                if (next_x < 0 || next_x >= ROWS || next_y < 0 || next_y >= COLS || board[next_x][next_y] != 0) {
                    continue;
                }
                board[next_x][next_y] = board[curr[0]][curr[1]]+1;
                q.offer(new int[]{next_x,next_y});
            }
        }
        for (int j = 0; j < pos.length; j++) {
            if (j == i) { continue; }
            int mvs = board[pos[j][0]][pos[j][1]]-1;
            moves[i][j] = mvs;
            moves[j][i] = mvs;
        }
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    private static void test1() {
        int kx = 1;
        int ky = 1;
        int[][] positions = {{0,0}};
        int expOutput = 4;
        Solution sol = new Solution();
        int output = sol.maxMoves(kx, ky, positions);
        boolean passed = output == expOutput;
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
    private static void test2() {
        int kx = 0;
        int ky = 2;
        int[][] positions = {{1,1},{2,2},{3,3}};
        int expOutput = 8;
        Solution sol = new Solution();
        int output = sol.maxMoves(kx, ky, positions);
        boolean passed = output == expOutput;
        System.out.println("test2:"+(passed ? "passed" : "failed"));
    }
    private static void test3() {
        int kx = 0;
        int ky = 0;
        int[][] positions = {{1,2},{2,4}};
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.maxMoves(kx, ky, positions);
        boolean passed = output == expOutput;
        System.out.println("test3:"+(passed ? "passed" : "failed"));
    }
}