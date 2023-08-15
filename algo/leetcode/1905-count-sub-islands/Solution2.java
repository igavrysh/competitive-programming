import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = grid2[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1) {
                    result += bfs(i, j, grid1, grid2);
                }
            }
        }
        return result;
    }

    private int bfs(int i, int j, int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length;
        int delta = 1;
        Queue<int[]> Q = new LinkedList<>();
        if (grid1[i][j] != 1) {
            return 0;
        }
        Q.add(new int[]{i,j});
        grid2[i][j] = 0;
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (grid1[curr[0]][curr[1]] == 0) {
                delta = 0;
            }
            for (int d = 0; d < dirs.length; d++) {
                int nextI = curr[0] + dirs[d][0];
                int nextJ = curr[1] + dirs[d][1];
                if (nextI < 0 || nextI >= rows || nextJ < 0 || nextJ >= cols || grid2[nextI][nextJ] == 0) {
                    continue;
                }
                grid2[nextI][nextJ] = 0;
                Q.offer(new int[]{nextI, nextJ});
            }
        }
        return delta;
    }

    public static void main(String[] args) {
        testSolution2_1();
        testSolution2_2();
        testSolution2_3();
        testSolution2_4();
    }

    public static void testSolution2_1() {
        int[][] grid1 = {
            {1,1,1,0,0},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {1,0,0,0,0},
            {1,1,0,1,1}
        };
        int[][] grid2 = {
            {1,1,1,0,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,1,0}
        };
        Solution2 s = new Solution2();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 3;
        boolean passed = actual == expected;
        System.out.println("testSolution2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_2() {
        int[][] grid1 = {
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,0,0,0},
            {1,1,1,1,1},
            {1,0,1,0,1}
        };
        int[][] grid2 = {
            {0,0,0,0,0},
            {1,1,1,1,1},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
        };
        Solution2 s = new Solution2();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 2;
        boolean passed = actual == expected;
        System.out.println("testSolution2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_3() {
        Solution2 s = new Solution2();
        int[][] grid1 = {
            {1,0,0,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,0,1,1,1,1,1},
            {1,0,1,1,1,1,0,1,1,1,1,0,1},
            {1,1,0,0,1,1,0,0,1,1,1,1,1},
            {0,1,0,1,1,1,0,1,1,1,0,1,1},
            {0,1,1,1,0,1,0,1,1,0,1,1,0},
            {1,0,1,1,1,0,1,1,1,1,1,1,0},
            {1,1,0,0,0,1,1,1,0,0,1,1,1},
            {0,0,1,0,1,1,1,1,1,1,0,0,1},
            {1,1,1,1,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,0,0,1,1,1,1},
            {1,0,0,1,0,1,1,0,0,0,1,0,0},
            {1,1,1,1,0,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,1,1,0,1,1,0,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1,0,1,1},
            {1,0,1,1,1,1,0,0,0,0,0,1,0},
            {1,1,0,1,0,0,1,1,1,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,0,1}
        };
        int[][] grid2 = {
            {1,0,0,0,1,1,1,1,1,0,1,1,1},
            {1,1,1,1,0,0,1,1,0,1,1,1,1},
            {0,1,0,0,0,1,1,1,1,1,1,1,1},
            {1,1,0,1,1,1,1,1,0,1,1,0,1},
            {0,1,0,1,0,1,1,1,0,1,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,0,1},
            {0,1,0,0,1,1,1,1,1,0,0,1,1},
            {1,1,1,0,0,1,1,1,1,1,1,0,1},
            {1,0,1,0,1,1,1,1,1,0,0,0,1},
            {0,1,0,1,1,1,1,0,0,1,1,1,0},
            {0,1,1,0,1,0,0,0,1,1,1,1,0},
            {1,1,1,0,1,0,1,0,0,1,1,0,1},
            {0,0,0,0,1,0,1,1,0,1,0,1,1},
            {0,0,1,1,0,1,0,1,0,0,1,1,1},
            {1,1,1,0,1,0,0,0,1,1,0,0,1},
            {0,1,1,0,1,0,0,1,0,0,0,1,0},
            {1,1,0,0,1,1,0,1,1,1,0,1,1},
            {0,1,0,1,1,1,0,1,1,0,0,1,0},
            {1,1,1,0,1,1,1,1,1,0,0,1,0},
            {0,1,1,1,1,1,0,1,0,1,0,0,1}
        };

        int actual = s.countSubIslands(grid1, grid2);
        int expected = 5;
        boolean passed = actual == expected;
        System.out.println("testSolution2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_4() {
        int[][] grid1 = {
            {1,1,1},
            {1,0,1}
        };
        int[][] grid2 = {
            {0,0,0},
            {1,0,1}
        };
        Solution2 s = new Solution2();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 2;
        boolean passed = actual == expected;
        System.out.println("testSolution2_4:" + (passed ? "passed" : "failed"));
    }
}