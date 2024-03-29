package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();

        testSolutionMemoization_1();
        testSolutionMemoization_2();
        testSolutionMemoization_3();
        testSolutionMemoization_4();
    }

    private static void test1() {
        Solution solution = new Solution();
        int output = solution.coinChange(new int[] { 1, 2, 5 }, 11);
        System.out.println("output:" + Integer.toString(output));
        boolean passed = output == 3;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        Solution solution = new Solution();
        int output = solution.coinChange(new int[] { 1 }, 0);
        boolean passed = output == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        Solution solution = new Solution();
        int output = solution.coinChange(new int[] { 186, 419, 83, 408 }, 6249);
        boolean passed = output == 20;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionMemoization_1() {
        SolutionMemoization solution = new SolutionMemoization();
        int output = solution.coinChange(new int[] { 1, 2, 5 }, 11);
        System.out.println("output:" + Integer.toString(output));
        boolean passed = output == 3;
        System.out.println("testSolutionMemoization_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionMemoization_2() {
        SolutionMemoization solution = new SolutionMemoization();
        int output = solution.coinChange(new int[] { 1 }, 0);
        boolean passed = output == 0;
        System.out.println("testSolutionMemoization_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionMemoization_3() {
        SolutionMemoization solution = new SolutionMemoization();
        int output = solution.coinChange(new int[] { 186, 419, 83, 408 }, 6249);
        boolean passed = output == 20;
        System.out.println("testSolutionMemoization_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionMemoization_4() {
        SolutionMemoization solution = new SolutionMemoization();
        int output = solution.coinChange(new int[] { 2 }, 41);
        boolean passed = output == -1;
        System.out.println("testSolutionMemoization_4:" + (passed ? "passed" : "failed"));
    }



}
