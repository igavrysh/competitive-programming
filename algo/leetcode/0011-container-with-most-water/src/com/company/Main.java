package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

        test7();

        test8();
        test9();

        testSolutionPracticePrjctr1();
        testSolutionPracticePrjctr2();
        testSolutionPracticePrjctr3();
        testSolutionPracticePrjctr4();
        testSolutionPracticePrjctr5();
        testSolutionPracticePrjctr6();
        testSolutionPracticePrjctr7();
        testSolutionPracticePrjctr8();
        testSolutionPracticePrjctr9();
    }

    private static void test1() {
        int[] height = { 1, 1 };
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.maxArea(height);
        boolean passed = output == 1;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] height = { 4, 3, 2, 1, 4 };
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.maxArea(height);
        boolean passed = output == 16;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int[] height = { 1, 2, 1 };
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.maxArea(height);
        boolean passed = output == 2;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        int[] height = { 1, 1 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 1;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    private static void test5() {
        int[] height = { 4, 3, 2, 1, 4 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 16;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }

    private static void test6() {
        int[] height = { 1, 2, 1 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 2;
        System.out.println("test6:" + (passed ? "passed" : "failed"));
    }

    private static void test7() {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 49;
        System.out.println("test7:" + (passed ? "passed" : "failed"));
    }

    private static void test8() {
        int[] height = { 2, 3, 4, 5, 18, 17, 6 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 17;
        System.out.println("test8:" + (passed ? "passed" : "failed"));
    }

    private static void test9() {
        int[] height = { 1, 3, 2, 5, 25, 24, 5 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxArea(height);
        boolean passed = output == 24;
        System.out.println("test9:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr1() {
        int[] height = { 1, 1 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 1;
        System.out.println("testSolutionPracticePrjctr1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr2() {
        int[] height = { 4, 3, 2, 1, 4 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 16;
        System.out.println("testSolutionPracticePrjctr2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr3() {
        int[] height = { 1, 2, 1 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 2;
        System.out.println("testSolutionPracticePrjctr3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr4() {
        int[] height = { 1, 1 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 1;
        System.out.println("testSolutionPracticePrjctr4:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr5() {
        int[] height = { 4, 3, 2, 1, 4 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 16;
        System.out.println("testSolutionPracticePrjctr5:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr6() {
        int[] height = { 1, 2, 1 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 2;
        System.out.println("testSolutionPracticePrjctr6:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr7() {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 49;
        System.out.println("testSolutionPracticePrjctr7:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr8() {
        int[] height = { 2, 3, 4, 5, 18, 17, 6 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 17;
        System.out.println("testSolutionPracticePrjctr8:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPracticePrjctr9() {
        int[] height = { 1, 3, 2, 5, 25, 24, 5 };
        SolutionPracticePrjctr s = new SolutionPracticePrjctr();
        int output = s.maxArea(height);
        boolean passed = output == 24;
        System.out.println("testSolutionPracticePrjctr9:" + (passed ? "passed" : "failed"));
    }

}
