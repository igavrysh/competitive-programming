package com.company;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
    }

    public static void test1() {
        Solution s = new Solution();
        int output = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        boolean passed = output == 5;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        boolean passed = s.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        SolutionIterative s = new SolutionIterative();
        int output = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        boolean passed = output == 5;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        SolutionIterative s = new SolutionIterative();
        boolean passed = s.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        SolutionIterative s = new SolutionIterative();
        boolean passed = s.maxProfit(new int[] { 1 }) == 0;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        SolutionIterative s = new SolutionIterative();
        boolean passed = s.maxProfit(new int[] { 1, 2 }) == 1;
        System.out.println("test6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        boolean passed = output == 5;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        boolean passed = s.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        boolean passed = s.maxProfit(new int[] { 1 }) == 0;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        boolean passed = s.maxProfit(new int[] { 1, 2 }) == 1;
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }
}
