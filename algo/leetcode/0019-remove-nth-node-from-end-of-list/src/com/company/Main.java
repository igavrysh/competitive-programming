package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
    }

    private static void test1() {
        ListNode input =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        ListNode output = s.removeNthFromEnd(input, 2);
        boolean passed = output.val == 1 && output.next.val == 2 && output.next.next.val == 3
                && output.next.next.next.val == 5 && output.next.next.next.next == null;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        ListNode input =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output.val == 1 && output.next.val == 2 && output.next.next.val == 3
                && output.next.next.next.val == 4 && output.next.next.next.next == null;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        ListNode input =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        ListNode output = s.removeNthFromEnd(input, 5);
        boolean passed = output.val == 2 && output.next.val == 3 && output.next.next.val == 4
                && output.next.next.next.val == 5 && output.next.next.next.next == null;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        ListNode input = new ListNode(1, new ListNode(2));
        Solution s = new Solution();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output.val == 1 && output.next == null;
        System.out.println("test4:" + (passed ? "passed" : "failed"));
    }

    private static void test5() {
        ListNode input = new ListNode(1);
        Solution s = new Solution();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output == null;
        System.out.println("test5:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_1() {
        ListNode input = new ListNode(1, new ListNode(2, 
            new ListNode(3, new ListNode(4, new ListNode(5)))));
        SolutionPractice2 s = new SolutionPractice2();
        ListNode output = s.removeNthFromEnd(input, 2);
        boolean passed = output.val == 1 && output.next.val == 2 && output.next.next.val == 3
                && output.next.next.next.val == 5 && output.next.next.next.next == null;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        SolutionPractice2 s = new SolutionPractice2();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output.val == 1 && output.next.val == 2 && output.next.next.val == 3
                && output.next.next.next.val == 4 && output.next.next.next.next == null;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_3() {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        SolutionPractice2 s = new SolutionPractice2();
        ListNode output = s.removeNthFromEnd(input, 5);
        boolean passed = output.val == 2 && output.next.val == 3 && output.next.next.val == 4
                && output.next.next.next.val == 5 && output.next.next.next.next == null;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_4() {
        ListNode input = new ListNode(1, new ListNode(2));
        SolutionPractice2 s = new SolutionPractice2();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output.val == 1 && output.next == null;
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_5() {
        ListNode input = new ListNode(1);
        SolutionPractice2 s = new SolutionPractice2();
        ListNode output = s.removeNthFromEnd(input, 1);
        boolean passed = output == null;
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }

}
