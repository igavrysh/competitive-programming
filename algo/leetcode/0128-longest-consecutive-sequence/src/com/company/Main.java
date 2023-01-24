package com.company;

class Main {
    public static void main(String[] args) {
        testSolutionHashSet_1();
        testSolutionHashSet_2();
        testSolutionHashSetOptimized_1();
        testSolutionHashSetOptimized_2();
        testSolutionMinMax_1();
        testSolutionMinMax_2();
        testSolutionMinMax_3();
        testSolutionMinMax_4();
        testSolutionHashSetOptimized2_1();
        testSolutionHashSetOptimized2_2();
        testSolutionHashSetOptimized2_3();
        testSolutionHashSetOptimized2_4();
        testSolutionHashSetOptimized2_5();
    }

    public static void testSolutionHashSet_1() {
        SolutionHashSet s = new SolutionHashSet();
        int output = s.longestConsecutive(new int[] {100,4,200,1,3,2});
        boolean passed = output == 4;
        System.out.println("testSolutionHashSet_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSet_2() {
        SolutionHashSet s = new SolutionHashSet();
        int output = s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
        boolean passed = output == 9;
        System.out.println("testSolutionHashSet_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized_1() {
        SolutionHashSetOptimized s = new SolutionHashSetOptimized();
        int output = s.longestConsecutive(new int[] {100,4,200,1,3,2});
        boolean passed = output == 4;
        System.out.println("testSolutionHashSetOptimized_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized_2() {
        SolutionHashSetOptimized s = new SolutionHashSetOptimized();
        int output = s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
        boolean passed = output == 9;
        System.out.println("testSolutionHashSetOptimized_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMinMax_1() {
        SolutionMinMax s = new SolutionMinMax();
        int output = s.longestConsecutive(new int[] {100,4,200,1,3,2});
        boolean passed = output == 4;
        System.out.println("testSolutionMinMax_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMinMax_2() {
        SolutionMinMax s = new SolutionMinMax();
        int output = s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
        boolean passed = output == 9;
        System.out.println("testSolutionMinMax_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMinMax_3() {
        SolutionMinMax s = new SolutionMinMax();
        int output = s.longestConsecutive(new int[] {});
        boolean passed = output == 0;
        System.out.println("testSolutionMinMax_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMinMax_4() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999});
        boolean passed = output == 10;
        System.out.println("testSolutionMinMax_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized2_1() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {100,4,200,1,3,2});
        boolean passed = output == 4;
        System.out.println("testSolutionHashSetOptimized2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized2_2() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
        boolean passed = output == 9;
        System.out.println("testSolutionHashSetOptimized2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized2_3() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {});
        boolean passed = output == 0;
        System.out.println("testSolutionHashSetOptimized2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized2_4() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999});
        boolean passed = output == 10;
        System.out.println("testSolutionHashSetOptimized2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashSetOptimized2_5() {
        SolutionHashSetOptimized2 s = new SolutionHashSetOptimized2();
        int output = s.longestConsecutive(new int[] {9,-8,9,8,-7,9,-4,6,5,5,6,7,-9,-5,-4,6,-8,-1,8,0,1,5,4});
        boolean passed = output == 6;
        System.out.println("testSolutionHashSetOptimized2_5: " + (passed ? "passed" : "failed"));
 
    }


}