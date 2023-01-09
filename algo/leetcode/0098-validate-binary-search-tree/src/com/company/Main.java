package com.company;

public class Main {

    public static void main(String[] args) {
        testSolutionRange1();
        testSolutionRange2();
        testSolutionRange3();
        testSolutionRange4();
        testSolutionInOrder1();
        testSolutionInOrder2();
        testSolutionInOrder3();
        testSolutionInOrder4();
    }

    public static void displayMessage(String test, boolean passed) {
        System.out.println(test + ": " +  (passed ? "passed" : "failed"));
    }

    public static void testSolutionRange1() {
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        SolutionRange solution = new SolutionRange();
        boolean passed = solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionRange2() {
        TreeNode tree = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode( 6)));
        SolutionRange solution = new SolutionRange();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionRange3() {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(1),
                null);
        SolutionRange solution = new SolutionRange();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionRange4() {
        TreeNode tree = new TreeNode(
                10,
                new TreeNode(5),
                new TreeNode( 15,
                        new TreeNode(6),
                        new TreeNode(20)));
        SolutionRange solution = new SolutionRange();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionInOrder1() {
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        SolutionInOrder solution = new SolutionInOrder();
        boolean passed = solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionInOrder2() {
        TreeNode tree = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode( 6)));
                        SolutionInOrder solution = new SolutionInOrder();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionInOrder3() {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(1),
                null);
                SolutionInOrder solution = new SolutionInOrder();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }

    public static void testSolutionInOrder4() {
        TreeNode tree = new TreeNode(
                10,
                new TreeNode(5),
                new TreeNode( 15,
                        new TreeNode(6),
                        new TreeNode(20)));
        SolutionInOrder solution = new SolutionInOrder();
        boolean passed = !solution.isValidBST(tree);
        displayMessage(Thread.currentThread().getStackTrace()[1].getMethodName(), passed);
    }
}
