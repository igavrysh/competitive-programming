package com.company;

public class SolutionPractice2 {

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        testSolutionPractice2_6();
        testSolutionPractice2_7();
        testSolutionPractice2_8();
    }

    public int numIslands(char[][] grid) {
        int output = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    output++;
                }
            }
        }
        return output;
    }

    private static int [][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    private void DFS(int i, int j, char[][] grid) {
        grid[i][j] = 'x';
        for (int k = 0; k < dirs.length; k++) {
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if (nextI >= 0 && nextI < grid.length 
                && nextJ >= 0 && nextJ < grid[0].length
                && grid[nextI][nextJ] == '1') {
                    DFS(nextI, nextJ, grid);
            }
        }
    }

    public static void testSolutionPractice2_1() {
        char[][] input = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        char[][] input = {
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        char[][] input = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        char[][] input = {
                { '1' },
                { '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        char[][] input = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_6() {
        char[][] input = {
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_7() {
        char[][] input = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_8() {
        char[][] input = {
                { '1' },
                { '1' }
        };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.numIslands(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_8:" + (passed ? "passed" : "failed"));
    }
}
