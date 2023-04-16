package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
        testSolution_5();
        testSolution_6();
        testSolution_7();
        testSolution_8();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        testSolutionPractice2_6();
        testSolutionPractice2_7();
        testSolutionPractice2_8();
        testSolutionPractice2_9();
    }

    public static void testSolution_1() {
        int[][] input = { { 1, 3 }, { 6, 9 } };
        int[] inputInsert = { 2, 5 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 }, { 6, 9 } });
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[][] input = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] inputInsert = { 4, 8 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } });
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int[][] input = {};
        int[] inputInsert = { 5, 7 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 5, 7 } });
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 2, 3 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 } });
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 2, 7 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 7 } });
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_6() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 6, 8 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 }, { 6, 8 } });
        System.out.println("testSolution_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_7() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 0, 0 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 0, 0 }, { 1, 5 } });
        System.out.println("testSolution_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_8() {
        int[][] input = { { 2, 5 }, { 6, 7 }, { 8, 9 } };
        int[] inputInsert = { 0, 1 };
        Solution s = new Solution();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 0, 1 }, { 2, 5 }, { 6, 7 }, { 8, 9 } });
        System.out.println("testSolution_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        int[][] input = { { 1, 3 }, { 6, 9 } };
        int[] inputInsert = { 2, 5 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 }, { 6, 9 } });
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[][] input = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] inputInsert = { 4, 8 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } });
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        int[][] input = {};
        int[] inputInsert = { 5, 7 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 5, 7 } });
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 2, 3 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 } });
        System.out.println("testSolutionPractice2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 2, 7 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 7 } });
        System.out.println("testSolutionPractice2_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_6() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 6, 8 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 5 }, { 6, 8 } });
        System.out.println("testSolutionPractice2_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_7() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 0, 0 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 0, 0 }, { 1, 5 } });
        System.out.println("testSolutionPractice2_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_8() {
        int[][] input = { { 2, 5 }, { 6, 7 }, { 8, 9 } };
        int[] inputInsert = { 0, 1 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 0, 1 }, { 2, 5 }, { 6, 7 }, { 8, 9 } });
        System.out.println("testSolutionPractice2_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_9() {
        int[][] input = { { 1, 5 } };
        int[] inputInsert = { 5, 7 };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.insert(input, inputInsert);
        boolean passed = Arrays.deepEquals(output, new int[][] { { 1, 7 } });
        System.out.println("testSolutionPractice2_9: " + (passed ? "passed" : "failed"));
    }
}
