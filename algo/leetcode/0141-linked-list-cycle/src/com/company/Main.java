package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
    }

    private static void test1() {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        Solution s = new Solution();
        boolean output = s.hasCycle(l1);
        boolean passed = output == true;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_1() {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        SolutionPractice2 s = new SolutionPractice2();
        boolean output = s.hasCycle(l1);
        boolean passed = output == true;
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;
        SolutionPractice2 s = new SolutionPractice2();
        boolean output = s.hasCycle(l1);
        boolean passed = output == true;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_3() {
        ListNode l1 = new ListNode(1);
        SolutionPractice2 s = new SolutionPractice2();
        boolean output = s.hasCycle(l1);
        boolean passed = output == false;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        boolean output = s.hasCycle(null);
        boolean passed = output == false;
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_5() {
        ListNode l1 = new ListNode(1);
        l1.next = l1;
        SolutionPractice2 s = new SolutionPractice2();
        boolean output = s.hasCycle(l1);
        boolean passed = output == true;
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }
}
