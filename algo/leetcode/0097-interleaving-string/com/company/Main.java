package com.company;

public class Main {
    public static void main(String[] args) {
        testSolution1Recursive1();
        testSolution1Recursive2();
        testSolution1Recursive3();
 
        Solution2RecursiveMemoization1();
        Solution2RecursiveMemoization2();
        Solution2RecursiveMemoization3();
        Solution2RecursiveMemoization4();
        
        testSolution3Iterative1();
        testSolution3Iterative2();
        testSolution3Iterative3();
        testSolution3Iterative4();
        testSolution3Iterative5();
        testSolution3Iterative6();

        testSolution4IterativeOptimized1();
        testSolution4IterativeOptimized2();

        testSolution4IterativeOptimized3();

        testSolution4IterativeOptimized4();
        testSolution4IterativeOptimized5();
        testSolution4IterativeOptimized6();
        testSolution4IterativeOptimized7();
    }

    public static void testSolution1Recursive1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution1Recursive1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1Recursive2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution1Recursive2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1Recursive3() {
        String s1 = "", s2 = "", s3 = "";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution1Recursive3: " + (passed ? "passed" : "failed"));
    }

    public static void Solution2RecursiveMemoization1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("Solution2RecursiveMemoization1: " + (passed ? "passed" : "failed"));
    }

    public static void Solution2RecursiveMemoization2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("Solution2RecursiveMemoization2: " + (passed ? "passed" : "failed"));
    }

    public static void Solution2RecursiveMemoization3() {
        String s1 = "", s2 = "", s3 = "";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("Solution2RecursiveMemoization3: " + (passed ? "passed" : "failed"));
    }

    public static void Solution2RecursiveMemoization4() {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Solution2RecursiveMemoization s = new Solution2RecursiveMemoization();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("Solution2RecursiveMemoization4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution3Iterative1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution3Iterative2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative3() {
        String s1 = "", s2 = "", s3 = "";
        Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution3Iterative3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative4() {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution3Iterative4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative5() {
        String s1 = "",
            s2 = "",
            s3 = "a";
            Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution3Iterative5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3Iterative6() {
        String s1 = "a",
            s2 = "",
            s3 = "a";
            Solution3Iterative s = new Solution3Iterative();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution3Iterative6: " + (passed ? "passed" : "failed"));
    }


    public static void testSolution4IterativeOptimized1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution4IterativeOptimized1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution4IterativeOptimized2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized3() {
        String s1 = "", s2 = "", s3 = "";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution4IterativeOptimized3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized4() {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution4IterativeOptimized4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized5() {
        String s1 = "",
            s2 = "",
            s3 = "a";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("testSolution4IterativeOptimized5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized6() {
        String s1 = "a",
            s2 = "",
            s3 = "a";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution4IterativeOptimized6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4IterativeOptimized7() {
        String s1 = "",
            s2 = "b",
            s3 = "b";
        Solution4IterativeOptimized s = new Solution4IterativeOptimized();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("testSolution4IterativeOptimized7: " + (passed ? "passed" : "failed"));
    }
}
