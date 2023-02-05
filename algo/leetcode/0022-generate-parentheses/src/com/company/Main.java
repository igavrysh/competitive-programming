package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        testSolution1();
        testSolutionBtOptimized1();
    }

    static void testSolution1() {
        Solution solution = new Solution();
        List<String> output = solution.generateParenthesis(3);
        boolean passed = output.contains("()()()")
                && output.contains("(())()")
                && output.contains("()(())")
                && output.contains("((()))")
                && output.contains("(()())")
                && output.size() == 5;
        System.out.println("testSolution1:" + (passed ? "passed" : "failed"));
    }

    static void testSolutionBtOptimized1() {
        SolutionBtOptimized s = new SolutionBtOptimized();
        List<String> output = s.generateParenthesis(3);
        boolean passed = output.contains("()()()")
                && output.contains("(())()")
                && output.contains("()(())")
                && output.contains("((()))")
                && output.contains("(()())")
                && output.size() == 5;
        System.out.println("SolutionBtOptimized:" + (passed ? "passed" : "failed"));
    }
}
