class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int R = dungeon.length;
        int C = dungeon[0].length;
        int[][] DP = new int[R][C];
        for (int j = C-1; j>=0; j--) {
            for (int i = R-1; i>=0; i--) {
                int toSurvive = dungeon[i][j] <= 0 ? (-1*dungeon[i][j]) + 1 : 1;
                int min = Integer.MAX_VALUE;
                if (j < C-1) {
                    if (toSurvive + dungeon[i][j] < DP[i][j+1]) {
                        min = Math.min(min, DP[i][j+1]-(toSurvive + dungeon[i][j]));
                    }
                }
                if (i < R-1) {
                    if (toSurvive + dungeon[i][j] < DP[i+1][j]) {
                        min = Math.min(min, DP[i+1][j]-(toSurvive + dungeon[i][j]));
                    }
                }
                DP[i][j] = toSurvive + (min < Integer.MAX_VALUE ? min : 0);
            }
        }
        return DP[0][0];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int expectedOutput = 7;
        Solution sol = new Solution();
        int output = sol.calculateMinimumHP(dungeon);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] dungeon = {{0}};
        int expectedOutput = 1;
        Solution sol = new Solution();
        int output = sol.calculateMinimumHP(dungeon);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[][] dungeon = {{100}};
        int expectedOutput = 1;
        Solution sol = new Solution();
        int output = sol.calculateMinimumHP(dungeon);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[][] dungeon = {{0,5},{-2,-3}};
        int expectedOutput = 1;
        Solution sol = new Solution();
        int output = sol.calculateMinimumHP(dungeon);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}