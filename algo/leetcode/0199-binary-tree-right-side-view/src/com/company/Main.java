package com.company;

import java.util.List;

public class Main {

    private static void test1() {
        TreeNode tn = new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(5)),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(4)));
        Solution s = new Solution();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 3
                && output.get(0) == 1
                && output.get(1) == 3
                && output.get(2) == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        TreeNode tn = null;
        Solution s = new Solution();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        TreeNode tn = new TreeNode(1);
        Solution s = new Solution();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 1
                && output.get(0) == 1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
