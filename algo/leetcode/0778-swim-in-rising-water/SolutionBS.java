// binary search solution

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionBS {
    public int swimInWater(int[][] grid) {
        int bad = -1, good = 50*50+1;
        while (good - bad > 1) {
            int m = (int)(bad + (good-bad)/2.0);
            if (bfs(grid, m)) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }

    private boolean bfs(int[][] grid, int waterLvl) {
        if (grid[0][0] > waterLvl) {
            return false;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{0,0}); 
        while (!Q.isEmpty()) {
            int[] p = Q.poll();
            if (p[0] == rows-1 && p[1] == cols-1) {
                return true;
            }
            for (int[] d : dirs) {
                int newI = p[0] + d[0], newJ = p[1] + d[1];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols 
                    && !visited[newI][newJ] && grid[newI][newJ] <= waterLvl
                ) {
                    visited[newI][newJ] = true;
                    Q.offer(new int[]{newI, newJ});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testSolutionBS_1();
        testSolutionBS_2();
        testSolutionBS_3();
        testSolutionBS_4();
    }

    public static void testSolutionBS_1() {
        int[][] grid =  {{0,2},{1,3}};
        int expected = 3;
        SolutionBS s = new SolutionBS();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionBS_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_2() {
        int[][] grid = {
            { 0, 1, 2, 3, 4},
            {24,23,22,21, 5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10, 9, 8, 7, 6}
        };
        int expected = 16;
        SolutionBS s = new SolutionBS();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionBS_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_3() {
        int[][] grid = {{3,2},{0,1}};
        int expected = 3;
        SolutionBS s = new SolutionBS();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionBS_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_4() {
        int[][] grid = {{0}};
        int expected = 0;
        SolutionBS s = new SolutionBS();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionBS_4: " + (passed ? "passed" : "failed"));
    }

}
