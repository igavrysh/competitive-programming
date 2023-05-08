package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        int[] comb = new int[] { 2, 3, 6, 7 };
        Solution solution = new Solution();
        List<List<Integer>> output = solution.combinationSum(comb, 7);
        boolean passed = output.size() == 2;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] comb = new int[] { 2, 3 };
        Solution solution = new Solution();
        List<List<Integer>> output = solution.combinationSum(comb, 7);
        boolean passed = output.size() == 1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int[] comb = new int[] { 1, 2 };
        Solution solution = new Solution();
        List<List<Integer>> output = solution.combinationSum(comb, 4);
        boolean passed = output.size() == 3;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        int[] comb = new int[] { 2, 3, 6, 7 };
        SolutionOptimized solution = new SolutionOptimized();
        List<List<Integer>> output = solution.combinationSum(comb, 7);
        boolean passed = output.size() == 2;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    private static void test5() {
        int[] comb = new int[] { 2, 3, 6, 7 };
        SolutionOptimizedX2 solution = new SolutionOptimizedX2();
        List<List<Integer>> output = solution.combinationSum(comb, 7);
        boolean passed = output.size() == 2;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }
}
