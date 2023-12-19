import java.util.Stack;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        long[] dis = new long[R*C+2];
        for (int i = 0; i < R*C; i++) {
            dis[i] = -1;
        }
        dis[R*C] = 0;
        dis[R*C+1] = -2;

        Stack<Integer> order = postOrder(R, C, matrix);
        while (!order.isEmpty()) {
            Integer curr = order.pop();
            if (curr == R*C) { 
                continue; 
            }
            if (curr == R * C + 1) {
                for (int i = 0; i < R*C; i++) {
                    if (dis[curr] > dis[i]-1) {
                        dis[curr] = dis[i]-1;
                    }
                }
                continue;
            }

            int r = curr / C;
            int c = curr % C;
            for (int d = 0; d < dirs.length; d++) {
                int fromR = r + dirs[d][0];
                int fromC = c + dirs[d][1];
                if (!(fromR >= 0 && fromR < R && fromC >= 0 && fromC < C)) {
                    continue;
                }

                if (matrix[fromR][fromC] >= matrix[r][c]) {
                    continue;
                }

                if (dis[r*C+c] > dis[fromR*C+fromC]-1) {
                    dis[r*C+c] = dis[fromR*C+fromC]-1;
                }
            }
        }
        return -1*(int)(dis[R*C+1])-1;
    }

    private Stack<Integer> postOrder(int R, int C, int[][] matrix) {
        boolean[] marked = new boolean[R*C+2];
        Stack<Integer> order = new Stack<>();
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                dfs(i, marked, order, R, C, matrix);
            }
        }
        return order;
    }

    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int curr, boolean[] marked, Stack<Integer> order, int R, int C, int[][] matrix) {
        marked[curr] = true;

        if (curr == R*C) {
            order.push(curr);
            for (int i = 0; i < R*C; i++) {
                if (!marked[i]) {
                    dfs(i, marked, order, R, C, matrix);
                }
                
            }
            marked[curr] = true;
            return;
        }

        if (curr == R*C+1) {
            order.push(curr);
            marked[curr] = true;
            return;
        }

        int r = curr / C;
        int c = curr % C;

        for (int d = 0; d < dirs.length; d++) {
            int newR = r + dirs[d][0];
            int newC = c + dirs[d][1];
            if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
                int newI = newR*C + newC;
                if (!marked[newI] && matrix[newR][newC] > matrix[r][c]) {
                    dfs(newI, marked, order, R, C, matrix);
                }
            }
        }
        if (!marked[R*C+1]) {
            dfs(R*C+1, marked, order, R, C, matrix);
        }
        marked[curr] = true;
        order.push(curr);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[][] matrix = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.longestIncreasingPath(matrix);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] matrix = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.longestIncreasingPath(matrix);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[][] matrix = {
            {1}
        };
        int expectedOutput = 1;
        Solution sol = new Solution();
        int output = sol.longestIncreasingPath(matrix);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}