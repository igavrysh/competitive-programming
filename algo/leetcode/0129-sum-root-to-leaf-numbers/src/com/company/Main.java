package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution solution = new Solution();
        int output = solution.sumNumbers(input);
        boolean passed = output == 25;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        TreeNode input = new TreeNode(1);
        Solution solution = new Solution();
        int output = solution.sumNumbers(input);
        boolean passed = output == 1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        Solution solution = new Solution();
        int output = solution.sumNumbers(null);
        boolean passed = output == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        SolutionSumInPlace solution = new SolutionSumInPlace();
        int output = solution.sumNumbers(input);
        boolean passed = output == 25;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    private static void test5() {
        TreeNode input = new TreeNode(1);
        SolutionSumInPlace solution = new SolutionSumInPlace();
        int output = solution.sumNumbers(input);
        boolean passed = output == 1;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }

    private static void test6() {
        SolutionSumInPlace solution = new SolutionSumInPlace();
        int output = solution.sumNumbers(null);
        boolean passed = output == 0;
        System.out.println("test6:" + (passed ? "passed" : "failed"));
    }
}
