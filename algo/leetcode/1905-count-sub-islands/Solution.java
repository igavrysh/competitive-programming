import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length;
        int k = 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid1[i][j] != 1) continue;
                Queue<int[]> Q = new LinkedList<>();
                Q.add(new int[]{i,j});
                grid1[i][j] = k;

                while (!Q.isEmpty()) {
                    int[] curr = Q.poll();
                    for (int d = 0; d < dirs.length; d++) {
                        int nextI = curr[0] + dirs[d][0];
                        int nextJ = curr[1] + dirs[d][1];
                        if (nextI < 0 || nextI >= rows || nextJ < 0 || nextJ >= cols || grid1[nextI][nextJ] != 1) {
                            continue;
                        }
                        grid1[nextI][nextJ] = k;
                        Q.add(new int[]{nextI,nextJ});
                    }
                }
                k++;
            }
        }
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] != 1) continue;
                Queue<int[]> Q = new LinkedList<>();
                Q.add(new int[]{i,j});
                int delta = 1;
                int id = grid1[i][j];
                if (id == 0) {
                    delta = 0;
                }
                grid2[i][j] = id;
                while (!Q.isEmpty()) {
                    int[] curr = Q.poll();
                    if (grid1[curr[0]][curr[1]] != id) {
                        delta = 0;
                    }
                    for (int d = 0; d < dirs.length; d++) {
                        int nextI = curr[0] + dirs[d][0];
                        int nextJ = curr[1] + dirs[d][1];
                        if (nextI < 0 || nextI >= rows || nextJ < 0 || nextJ >= cols || grid2[nextI][nextJ] != 1) {
                            continue;
                        }
                        grid2[nextI][nextJ] = id;
                        Q.add(new int[]{nextI,nextJ});
                    }
                }
                result += delta;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testSolution_3();
        testSolution_1();
        testSolution_2();
        testSolution_4();
    }

    public static void testSolution_1() {
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
        Solution s = new Solution();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 3;
        boolean passed = actual == expected;
        System.out.println("testSolution_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
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
        Solution s = new Solution();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 2;
        boolean passed = actual == expected;
        System.out.println("testSolution_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        Solution s = new Solution();
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
        System.out.println("testSolution_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        int[][] grid1 = {
            {1,1,1},
            {1,0,1}
        };
        int[][] grid2 = {
            {0,0,0},
            {1,0,1}
        };
        Solution s = new Solution();
        int actual = s.countSubIslands(grid1, grid2);
        int expected = 2;
        boolean passed = actual == expected;
        System.out.println("testSolution_4:" + (passed ? "passed" : "failed"));
    }
}