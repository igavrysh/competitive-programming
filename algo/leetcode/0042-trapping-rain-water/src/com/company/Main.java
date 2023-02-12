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
        test10();

        testSolutionDPPractice2_1();
        testSolutionDPPractice2_2();
        testSolutionDPPractice2_3();
        testSolutionDPPractice2_4();
        testSolutionDPPractice2_5();
        testSolutionDPPractice2_6();
        testSolutionDPPractice2_7();
        testSolutionDPPractice2_8();
        testSolutionDPPractice2_9();
        testSolutionDPPractice2_10();
    }

    public static void test1() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0 });
        boolean passed = output == 0;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 0, 0 });
        boolean passed = output == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 2, 3 });
        boolean passed = output == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 0, 10, 0, 0 });
        boolean passed = output == 0;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 1, 0, 1 });
        boolean passed = output == 1;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 1, 0 });
        boolean passed = output == 0;
        System.out.println("test6:" + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 0, 1, 0, 1 });
        boolean passed = output == 2;
        System.out.println("test7:" + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        boolean passed = output == 6;
        System.out.println("test8:" + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 4, 2, 0, 3, 2, 5 });
        boolean passed = output == 9;
        System.out.println("test9:" + (passed ? "passed" : "failed"));
    }

    public static void test10() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 7, 1, 4, 6 });
        boolean passed = output == 7;
        System.out.println("test10:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_1() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_2() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_3() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 2, 3 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_4() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 0, 10, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_5() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 1, 0, 1 });
        boolean passed = output == 1;
        System.out.println("testSolutionDPPractice2_5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_6() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 1, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_7() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 0, 1, 0, 1 });
        boolean passed = output == 2;
        System.out.println("testSolutionDPPractice2_7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_8() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        boolean passed = output == 6;
        System.out.println("testSolutionDPPractice2_8:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_9() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 4, 2, 0, 3, 2, 5 });
        boolean passed = output == 9;
        System.out.println("testSolutionDPPractice2_9:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_10() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 7, 1, 4, 6 });
        boolean passed = output == 7;
        System.out.println("testSolutionDPPractice2_10:" + (passed ? "passed" : "failed"));
    }

}
