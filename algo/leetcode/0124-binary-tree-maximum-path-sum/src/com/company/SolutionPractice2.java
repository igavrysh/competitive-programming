package com.company;

public class SolutionPractice2 {

    private int maxPathSeen = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new RuntimeException("passed root is null");
        }
        maxPathSeen = root.val;
        postOrder(root);
        return maxPathSeen;
    }

    private int postOrder(TreeNode node) {
        int lMax = node.left == null ? Integer.MIN_VALUE : postOrder(node.left);
        int rMax = node.right == null ? Integer.MIN_VALUE : postOrder(node.right);

        int res = node.val;
        
        if (lMax != Integer.MIN_VALUE) {
            res = Math.max(res, lMax + node.val);
        }

        if (rMax != Integer.MIN_VALUE) {
            res = Math.max(res, rMax + node.val);
        }

        maxPathSeen = Math.max(maxPathSeen, res);

        if (rMax != Integer.MIN_VALUE && lMax != Integer.MIN_VALUE) {
            maxPathSeen = Math.max(maxPathSeen, node.val + lMax + rMax);
        }

        return res;
    }

    public static void main(String[] args) {
        testSolutionPractice2_3();
        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public static void testSolutionPractice2_1() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        int expOutput = 6;
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxPathSum(root);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        TreeNode root = new TreeNode(-10, 
            new TreeNode(9, null, null), 
            new TreeNode(20, 
                new TreeNode(15, null, null), 
                new TreeNode(7, null, null)));
        int expOutput = 42;
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxPathSum(root);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);
        int expOutput = 3;
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.maxPathSum(root);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
