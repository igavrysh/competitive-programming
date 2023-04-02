package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        
        testSolutionHeap1();
        testSolutionHeap2();

        testSolutionPQ1();
        testSolutionPQ2();
    }

    public static void test1() {
        int[][] input = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        Solution s = new Solution();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 1 && Arrays.equals(output[0], new int[] { -2, 2 });
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] input = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        Solution s = new Solution();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 2 && Arrays.deepEquals(output, new int[][] { { 3, 3 }, { -2, 4 } });
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHeap1() {
        int[][] input = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        SolutionHeap s = new SolutionHeap();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 1 && Arrays.equals(output[0], new int[] { -2, 2 });
        System.out.println("testSolutionHeap1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHeap2() {
        int[][] input = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        SolutionHeap s = new SolutionHeap();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 2 && Arrays.deepEquals(output, new int[][] { { 3, 3 }, { -2, 4 } });
        System.out.println("testSolutionHeap2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPQ1() {
        int[][] input = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        SolutionPQ s = new SolutionPQ();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 1 && Arrays.equals(output[0], new int[] { -2, 2 });
        System.out.println("testSolutionPQ1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPQ2() {
        int[][] input = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        SolutionPQ s = new SolutionPQ();
        int[][] output = s.kClosest(input, k);
        int[][] expectedOutput = new int[][] { { 3, 3 }, { -2, 4 } };
        
        boolean passed = true;

        for (int i = 0; i < output.length; i++) {
            boolean matched = false;
            for (int j = 0; j < expectedOutput.length; j++) {
                if (Arrays.equals(output[i], expectedOutput[j])) {
                    matched = true;
                }
            }

            if (!matched) {
                passed = false;
            }
        }
        System.out.println("testSolutionPQ2: " + (passed ? "passed" : "failed"));
    }
}
