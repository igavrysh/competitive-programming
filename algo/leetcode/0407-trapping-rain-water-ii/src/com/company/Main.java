package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
    }

    public static void testSolution1() {
        Solution s = new Solution();
        int[][] heatMap = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int output = s.trapRainWater(heatMap);
        boolean passed = output == 4;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        Solution s = new Solution();
        int[][] heatMap = new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        int output = s.trapRainWater(heatMap);
        boolean passed = output == 10;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }
}