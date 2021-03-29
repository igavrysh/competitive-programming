package com.company;

public class Main {

    public static void test1() {
        TreeNode input = new TreeNode(
            8,
            new TreeNode(
                3,
                new TreeNode(1, null, null),
                new TreeNode(
                    6,
                    new TreeNode(4, null, null),
                    new TreeNode(7, null, null)
                )
            ),
            new TreeNode(
                10,
                null,
                new TreeNode(
                    14,
                    new TreeNode(13, null, null),
                    null
                )
            )
        );
        Solution s = new Solution();
        int output = s.maxAncestorDiff(input);
        boolean passed = output == 7;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode input = new TreeNode(
            1,
            null,
            new TreeNode(
                2,
                null,
                new TreeNode(
                    0,
                    new TreeNode(3, null, null),
                    null
                )
            )
        );
        Solution s = new Solution();
        int output = s.maxAncestorDiff(input);
        boolean passed = output == 3;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
