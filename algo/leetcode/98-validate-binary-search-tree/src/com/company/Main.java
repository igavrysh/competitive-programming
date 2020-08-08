package com.company;

public class Main {

    public static void test1() {
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Solution solution = new Solution();
        boolean passed = solution.isValidBST(tree) == true;
        System.out.println(passed ? "test1 passed" : "test1 failed");
    }

    public static void test2() {
        TreeNode tree = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode( 6)));
        Solution solution = new Solution();
        boolean passed = solution.isValidBST(tree) == false;
        System.out.println(passed ? "test2 passed" : "test2 failed");
    }

    public static void test3() {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(1),
                null);
        Solution solution = new Solution();
        boolean passed = solution.isValidBST(tree) == false;
        System.out.println(passed ? "test3 passed" : "test3 failed");
    }

    public static void test4() {
        TreeNode tree = new TreeNode(
                10,
                new TreeNode(5),
                new TreeNode( 15,
                        new TreeNode(6),
                        new TreeNode(20)));
        Solution solution = new Solution();
        boolean passed = solution.isValidBST(tree) == false;
        System.out.println(passed ? "test4 passed" : "test4 failed");
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }


}
