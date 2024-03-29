package com.company;

import javax.imageio.plugins.tiff.TIFFTagSet;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public static void test1() {
        ListNode val1 = new ListNode(2);
        val1.next = new ListNode(4);
        val1.next.next = new ListNode(3);

        ListNode val2 = new ListNode(5);
        val2.next = new ListNode(6);
        val2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(val1, val2);

        boolean checked = result.val == 7 && result.next.val == 0 && result.next.next.val == 8;

        System.out.println(checked ? "test passed" : "test failed");
    }

    public static void test2() {
        ListNode val1 = new ListNode(1);
        val1.next = new ListNode(8);

        ListNode val2 = new ListNode(0);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(val1, val2);

        boolean checked = result.val == 1 && result.next.val == 8;

        System.out.println(checked ? "test passed" : "test failed");
    }

    public static void testSolutionPractice2_1() {
        ListNode val1 = new ListNode(2);
        val1.next = new ListNode(4);
        val1.next.next = new ListNode(3);

        ListNode val2 = new ListNode(5);
        val2.next = new ListNode(6);
        val2.next.next = new ListNode(4);

        SolutionPractice2 solution = new SolutionPractice2();
        ListNode result = solution.addTwoNumbers(val1, val2);

        boolean passed = result.val == 7 && result.next.val == 0 && result.next.next.val == 8;

        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        ListNode val1 = new ListNode(1);
        val1.next = new ListNode(8);

        ListNode val2 = new ListNode(0);

        SolutionPractice2 solution = new SolutionPractice2();
        ListNode result = solution.addTwoNumbers(val1, val2);

        boolean passed = result.val == 1 && result.next.val == 8;

        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

}
