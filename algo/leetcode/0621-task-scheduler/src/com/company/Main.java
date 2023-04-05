package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();

        testSolutionMath1();
        testSolutionMath2();
        testSolutionMath3();
    }

    public static void test1() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        Solution s = new Solution();
        boolean passed = s.leastInterval(tasks, n) == 8;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 0;
        Solution s = new Solution();
        boolean passed = s.leastInterval(tasks, n) == 6;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int n = 2;
        Solution s = new Solution();
        boolean passed = s.leastInterval(tasks, n) == 16;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMath1() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        SolutionMath s = new SolutionMath();
        boolean passed = s.leastInterval(tasks, n) == 8;
        System.out.println("testSolutionMath1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMath2() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 0;
        SolutionMath s = new SolutionMath();
        boolean passed = s.leastInterval(tasks, n) == 6;
        System.out.println("testSolutionMath2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMath3() {
        char[] tasks = new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int n = 2;
        SolutionMath s = new SolutionMath();
        boolean passed = s.leastInterval(tasks, n) == 16;
        System.out.println("testSolutionMath3:" + (passed ? "passed" : "failed"));
    }

}
