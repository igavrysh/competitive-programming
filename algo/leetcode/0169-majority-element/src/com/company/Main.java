package com.company;

class Main {

    public static void main(String[] args) {
        testSolutionHashMap1();
        testSolutionHashMap2();

        testSolutionQuickFind1();
        testSolutionQuickFind2();
        testSolutionQuickFind3();
        testSolutionQuickFind4();

        testSolutionOptimized1();
        testSolutionOptimized2();
        testSolutionOptimized3();
        testSolutionOptimized4();

        testSolutionRandom1();
        testSolutionRandom2();
        testSolutionRandom3();
        testSolutionRandom4();
    }

    public static void testSolutionHashMap1() {
        SolutionHashMap s = new SolutionHashMap();
        int output = s.majorityElement(new int[]{3,2,3});
        boolean passed = output == 3;
        System.out.println("testSolutionHashMap1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashMap2() {
        SolutionHashMap s = new SolutionHashMap();
        int output = s.majorityElement(new int[]{2,2,1,1,1,2,2});
        boolean passed = output == 2;
        System.out.println("testSolutionHashMap2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionQuickFind1() {
        SolutionQuickFind s = new SolutionQuickFind();
        int output = s.majorityElement(new int[]{3,2,3});
        boolean passed = output == 3;
        System.out.println("testSolutionQuickFind1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQuickFind2() {
        SolutionQuickFind s = new SolutionQuickFind();
        int output = s.majorityElement(new int[]{2,2,1,1,1,2,2});
        boolean passed = output == 2;
        System.out.println("testSolutionQuickFind2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionQuickFind3() {
        SolutionQuickFind s = new SolutionQuickFind();
        int[] nums = new int[]{6,6,6,7,7};
        int output = s.majorityElement(nums);
        boolean passed = output == 6;
        System.out.println("testSolutionQuickFind3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionQuickFind4() {
        SolutionQuickFind s = new SolutionQuickFind();
        int[] nums = new int[]{-1,1,1,1,2,1};
        int output = s.majorityElement(nums);
        boolean passed = output == 1;
        System.out.println("testSolutionQuickFind4: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionOptimized1() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.majorityElement(new int[]{3,2,3});
        boolean passed = output == 3;
        System.out.println("testSolutionOptimized1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized2() {
        SolutionOptimized s = new SolutionOptimized();
        int output = s.majorityElement(new int[]{2,2,1,1,1,2,2});
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionOptimized3() {
        SolutionOptimized s = new SolutionOptimized();
        int[] nums = new int[]{6,6,6,7,7};
        int output = s.majorityElement(nums);
        boolean passed = output == 6;
        System.out.println("testSolutionOptimized3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionOptimized4() {
        SolutionOptimized s = new SolutionOptimized();
        int[] nums = new int[]{-1,1,1,1,2,1};
        int output = s.majorityElement(nums);
        boolean passed = output == 1;
        System.out.println("testSolutionOptimized4: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionRandom1() {
        SolutionRandom s = new SolutionRandom();
        int output = s.majorityElement(new int[]{3,2,3});
        boolean passed = output == 3;
        System.out.println("testSolutionRandom1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRandom2() {
        SolutionRandom s = new SolutionRandom();
        int output = s.majorityElement(new int[]{2,2,1,1,1,2,2});
        boolean passed = output == 2;
        System.out.println("testSolutionRandom2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionRandom3() {
        SolutionRandom s = new SolutionRandom();
        int[] nums = new int[]{6,6,6,7,7};
        int output = s.majorityElement(nums);
        boolean passed = output == 6;
        System.out.println("testSolutionRandom3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionRandom4() {
        SolutionRandom s = new SolutionRandom();
        int[] nums = new int[]{-1,1,1,1,2,1};
        int output = s.majorityElement(nums);
        boolean passed = output == 1;
        System.out.println("testSolutionRandom4: " + (passed ? "passed" : "failed"));    
    }
}