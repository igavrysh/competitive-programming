package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        testSolutionOptimized_1();
        testSolutionOptimized_2();
        testSolutionOptimized_3();
        testSolutionOptimized_4();
    }

    public static void test1() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 4
                && input.next.next.val == 2
                && input.next.next.next.val == 3
                && input.next.next.next.next == null;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 5
                && input.next.next.val == 2
                && input.next.next.next.val == 4
                && input.next.next.next.next.val == 3
                && input.next.next.next.next.next == null;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        ListNode input = new ListNode(1, null);
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next == null;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        ListNode input = null;
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input == null;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized_1() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 4
                && input.next.next.val == 2
                && input.next.next.next.val == 3
                && input.next.next.next.next == null;
        System.out.println("testSolutionOptimized_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized_2() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 5
                && input.next.next.val == 2
                && input.next.next.next.val == 4
                && input.next.next.next.next.val == 3
                && input.next.next.next.next.next == null;
        System.out.println("testSolutionOptimized_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized_3() {
        ListNode input = new ListNode(1, null);
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next == null;
        System.out.println("testSolutionOptimized_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized_4() {
        ListNode input = null;
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input == null;
        System.out.println("testSolutionOptimized_4: " + (passed ? "passed" : "failed"));
    }
}
