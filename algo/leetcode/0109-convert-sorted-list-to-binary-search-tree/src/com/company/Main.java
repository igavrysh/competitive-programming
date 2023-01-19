package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        ListNode l = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        Solution s = new Solution();
        TreeNode res = s.sortedListToBST(l);
        List<Integer> output = TreeNode.toList(res);
        boolean passed = Arrays.deepEquals(output.toArray(), new Integer[]{0,-3,9,-10,null,5});
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        ListNode l = new ListNode(1);
        Solution s = new Solution();
        TreeNode res = s.sortedListToBST(l);
        List<Integer> output = TreeNode.toList(res);
        boolean passed = Arrays.deepEquals(output.toArray(), new Integer[]{1});
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        ListNode l = null;
        Solution s = new Solution();
        TreeNode res = s.sortedListToBST(l);
        boolean passed = res == null;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
}