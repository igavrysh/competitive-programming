package com.company;

class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        TreeNode t = new TreeNode(
            -10, 
            new TreeNode(9),
            new TreeNode(
                20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );
        Solution s = new Solution();
        int output = s.maxPathSum(t);
        boolean passed = output == 42;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode t = new TreeNode(
            1, 
            new TreeNode(2),
            new TreeNode(3)
        );
        Solution s = new Solution();
        int output = s.maxPathSum(t);
        boolean passed = output == 6;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        TreeNode t = null;
        Solution s = new Solution();
        int output = s.maxPathSum(t);
        boolean passed = output == 0;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        TreeNode t = new TreeNode(-10);
        Solution s = new Solution();
        int output = s.maxPathSum(t);
        boolean passed = output == -10;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        TreeNode t = new TreeNode(2, new TreeNode(-1), null);
        Solution s = new Solution();
        int output = s.maxPathSum(t);
        boolean passed = output == 2;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }
}