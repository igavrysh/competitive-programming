package com.company;

public class Main {

    public static void testRecursive1() {
        TreeNode tree = new TreeNode(
                4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        SolutionRecursive solution = new SolutionRecursive();
        TreeNode output = solution.invertTree(tree);

        boolean passed = output.val == 4
                && output.left.val == 7
                && output.right.val == 2
                && output.left.left.val == 9
                && output.left.right.val == 6
                && output.right.left.val == 3
                && output.right.right.val == 1;

        System.out.println("testRecursive1:" + (passed ? "passed" : "failed"));
    }

    public static void testRecursiveEmpty() {
        TreeNode tree = new TreeNode();
        SolutionRecursive solution = new SolutionRecursive();
        TreeNode output = solution.invertTree(tree);

        boolean passed = output.left == null
                && output.right == null;
        System.out.println("testRecursiveEmpty:" + (passed ? "passed" : "failed"));
    }

    public static void testIterative1() {
        TreeNode tree = new TreeNode(
                4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        SolutionIterative solution = new SolutionIterative();
        TreeNode output = solution.invertTree(tree);

        boolean passed = output.val == 4
                && output.left.val == 7
                && output.right.val == 2
                && output.left.left.val == 9
                && output.left.right.val == 6
                && output.right.left.val == 3
                && output.right.right.val == 1;

        System.out.println("testIterative1:" + (passed ? "passed" : "failed"));
    }

    public static void testIterativeEmpty() {
        TreeNode tree = new TreeNode();
        SolutionIterative solution = new SolutionIterative();
        TreeNode output = solution.invertTree(tree);

        boolean passed = output.left == null
                && output.right == null;
        System.out.println("testIterativeEmpty:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        testRecursive1();
        testRecursiveEmpty();
        testIterative1();
        testIterativeEmpty();
    }
}
