import java.util.PriorityQueue;

class SolutionPQ {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int rows = grid.length, cols = grid[0].length;
        int level = 0;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((int[] p1, int[] p2) -> grid[p1[0]][p1[1]] - grid[p2[0]][p2[1]]);
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        PQ.offer(new int[]{0, 0});
        while (!PQ.isEmpty()) {
            int[] p = PQ.poll();
            int pLevel = grid[p[0]][p[1]];
            if (level < pLevel) {
                level += pLevel - level;
            }
            if (p[0] == rows-1 && p[1] == cols-1) {
                break;
            }
            for (int[] d : dirs) {
                int newI = p[0] + d[0];
                int newJ = p[1] + d[1];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                    if (!visited[newI][newJ]) {
                        visited[newI][newJ] = true;
                        PQ.offer(new int[]{newI,newJ});
                    }
                }
            }
        }
        return level;
    }
    
    public static void main(String[] args) {
        testSolutionPQ_1();
        testSolutionPQ_2();
    }

    public static void testSolutionPQ_1() {
        int[][] grid =  {{0,2},{1,3}};
        int expected = 3;
        SolutionPQ s = new SolutionPQ();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionPQ_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPQ_2() {
        int[][] grid = {
            { 0, 1, 2, 3, 4},
            {24,23,22,21, 5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10, 9, 8, 7, 6}};
        int expected = 16;
        SolutionPQ s = new SolutionPQ();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionPQ_2: " + (passed ? "passed" : "failed"));
    }
}