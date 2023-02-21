package com.company;

class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();

        testSolutionOptimized1();
        testSolutionOptimized2();
        testSolutionOptimized3();
        testSolutionOptimized4();
        testSolutionOptimized5();
        testSolutionOptimized6();
        testSolutionOptimized7();
    }

    public static void test1() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        boolean passed = output == 2;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{1,2,2});
        boolean passed = output == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{1,1,2});
        boolean passed = output == 2;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        boolean passed = output == 10;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        boolean passed = output == 10;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3});
        boolean passed = output == 2;
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        Solution s = new Solution();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3});
        boolean passed = output == 2;
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized1() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized2() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{1,2,2});
        boolean passed = output == 1;
        System.out.println("testSolutionOptimized2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized3() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{1,1,2});
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized4() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        boolean passed = output == 10;
        System.out.println("testSolutionOptimized4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized5() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        boolean passed = output == 10;
        System.out.println("testSolutionOptimized5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized6() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3});
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized7() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.singleNonDuplicate(new int[]{1,1,2,3,3});
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized7: " + (passed ? "passed" : "failed"));
    }
}