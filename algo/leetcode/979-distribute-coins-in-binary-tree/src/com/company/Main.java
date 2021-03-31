package com.company;

public class Main {

    private static void test1() {
        TreeNode input = new TreeNode(
            3,
            new TreeNode(0, null, null),
            new TreeNode(0, null, null));
        Solution s = new Solution();
        int output = s.distributeCoins(input);
        boolean passed = output == 2;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        TreeNode input = new TreeNode(
            0,
            new TreeNode(3, null, null),
            new TreeNode(0, null, null));
        Solution s = new Solution();
        int output = s.distributeCoins(input);
        boolean passed = output == 3;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        TreeNode input = new TreeNode(
            1,
            new TreeNode(0, null, null),
            new TreeNode(2, null, null));
        Solution s = new Solution();
        int output = s.distributeCoins(input);
        boolean passed = output == 2;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        TreeNode input = new TreeNode(
            1,
            new TreeNode(
                0,
                null,
                new TreeNode(3, null, null)),
            new TreeNode(0, null, null));
        Solution s = new Solution();
        int output = s.distributeCoins(input);
        boolean passed = output == 4;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
	      test1();
	      test2();
	      test3();
	      test4();
    }
}
