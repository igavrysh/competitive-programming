package com.company;

public class Main {

    public static void test1() {
        TreeNode tree = new TreeNode(
                6,
                new TreeNode(7,
                        new TreeNode(
                                2,
                                new TreeNode(9),
                                null),
                        new TreeNode(7)),
                new TreeNode(8,
                        new TreeNode(1),
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(5))));
        Solution s = new Solution();
        int output = s.sumEvenGrandparent(tree);
        boolean passed = output == 18;
        System.out.println("test1:"+ (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
    }
}
