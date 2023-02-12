package com.company;

public class Main {
    public static void main(String[] args) {
        testSolutionTwoPointers1();
        testSolutionTwoPointers2();
        testSolutionTwoPointers3();
        testSolutionTwoPointers4();
        testSolutionTwoPointers5();
        testSolutionTwoPointers6();
        testSolutionTwoPointers7();
        testSolutionTwoPointers8();
        testSolutionTwoPointers9();
        testSolutionTwoPointers10();

        testSolutionStack1();
        testSolutionStack2();
        testSolutionStack3();
        testSolutionStack4();
        testSolutionStack5();
        testSolutionStack6();
        testSolutionStack7();
        testSolutionStack8();
        testSolutionStack9();
        testSolutionStack10();

        testSolutionDPPractice2_1();
        testSolutionDPPractice2_2();
        testSolutionDPPractice2_3();
        testSolutionDPPractice2_4();
        testSolutionDPPractice2_5();
        testSolutionDPPractice2_6();
        testSolutionDPPractice2_7();
        testSolutionDPPractice2_8();
        testSolutionDPPractice2_9();
        testSolutionDPPractice2_10();
    }

    public static void testSolutionStack1() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionStack1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack2() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionStack2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack3() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 1, 2, 3 });
        boolean passed = output == 0;
        System.out.println("testSolutionStack3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack4() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 0, 10, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionStack4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack5() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 1, 0, 1 });
        boolean passed = output == 1;
        System.out.println("testSolutionStack5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack6() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 1, 1, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionStack6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack7() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 1, 0, 1, 0, 1 });
        boolean passed = output == 2;
        System.out.println("testSolutionStack7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack8() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        boolean passed = output == 6;
        System.out.println("testSolutionStack8:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack9() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 4, 2, 0, 3, 2, 5 });
        boolean passed = output == 9;
        System.out.println("testSolutionStack9:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack10() {
        SolutionStack s = new SolutionStack();
        int output = s.trap(new int[] { 0, 7, 1, 4, 6 });
        boolean passed = output == 7;
        System.out.println("testSolutionStack10:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers1() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionTwoPointers1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers2() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionTwoPointers2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers3() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 2, 3 });
        boolean passed = output == 0;
        System.out.println("testSolutionTwoPointers3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers4() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 0, 10, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionTwoPointers4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers5() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 1, 0, 1 });
        boolean passed = output == 1;
        System.out.println("testSolutionTwoPointers5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers6() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 1, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionTwoPointers6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers7() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 0, 1, 0, 1 });
        boolean passed = output == 2;
        System.out.println("testSolutionTwoPointers7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers8() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        boolean passed = output == 6;
        System.out.println("testSolutionTwoPointers8:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers9() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 4, 2, 0, 3, 2, 5 });
        boolean passed = output == 9;
        System.out.println("testSolutionTwoPointers9:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers10() {
        SolutionTwoPointers s = new SolutionTwoPointers();
        int output = s.trap(new int[] { 0, 7, 1, 4, 6 });
        boolean passed = output == 7;
        System.out.println("testSolutionTwoPointers10:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_1() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_2() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_3() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 2, 3 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_4() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 0, 10, 0, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_5() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 1, 0, 1 });
        boolean passed = output == 1;
        System.out.println("testSolutionDPPractice2_5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_6() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 1, 0 });
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_7() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 0, 1, 0, 1 });
        boolean passed = output == 2;
        System.out.println("testSolutionDPPractice2_7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_8() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        boolean passed = output == 6;
        System.out.println("testSolutionDPPractice2_8:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_9() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 4, 2, 0, 3, 2, 5 });
        boolean passed = output == 9;
        System.out.println("testSolutionDPPractice2_9:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDPPractice2_10() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.trap(new int[] { 0, 7, 1, 4, 6 });
        boolean passed = output == 7;
        System.out.println("testSolutionDPPractice2_10:" + (passed ? "passed" : "failed"));
    }

}
