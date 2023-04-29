package com.company;

public class SolutionPractice2 {

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        testSolutionPractice2_6();
        testSolutionPractice2_7();
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int acc) {
        acc = acc*10 + node.val;
        if (node.left == null && node.right == null) {
            return acc;
        }
        int lhs = 0, rhs = 0;
        if (node.left != null) {
            lhs = dfs(node.left, acc);
        }
        if (node.right != null) {
            rhs = dfs(node.right, acc);
        }
        return lhs + rhs; 
    }

    private static void testSolutionPractice2_1() {
        TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(input);
        boolean passed = output == 25;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        TreeNode input = new TreeNode(1);
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_3() {
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(null);
        boolean passed = output == 0;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_4() {
        TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(input);
        boolean passed = output == 25;
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_5() {
        TreeNode input = new TreeNode(1);
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(input);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_6() {
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(null);
        boolean passed = output == 0;
        System.out.println("testSolutionPractice2_6:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_7() {
        TreeNode input = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
        SolutionPractice2 solution = new SolutionPractice2();
        int output = solution.sumNumbers(input);
        boolean passed = output == 123;
        System.out.println("testSolutionPractice2_7:" + (passed ? "passed" : "failed"));
    }

}
