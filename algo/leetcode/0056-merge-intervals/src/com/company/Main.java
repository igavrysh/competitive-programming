package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSolutionPractice2_3();

        testSolution_1();
        testSolution_2();
        testSolutionPractice2_1();
        testSolutionPractice2_2();

        testSolutionPractice2Linear_1();
        testSolutionPractice2Linear_2();
        testSolutionPractice2Linear_3();
    }

    public static void testSolution_1() {
        int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        Solution s = new Solution();
        int[][] output = s.merge(input);
        boolean passed = output.length == 3
                && Arrays.deepEquals(output, new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } });
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[][] input = { { 1, 4 }, { 4, 5 } };
        Solution s = new Solution();
        int[][] output = s.merge(input);
        boolean passed = output.length == 1
                && Arrays.deepEquals(output, new int[][] { { 1, 5 } });
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }


    public static void testSolutionPractice2_1() {
        int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.merge(input);
        boolean passed = output.length == 3
                && Arrays.deepEquals(output, new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } });
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[][] input = { { 1, 4 }, { 4, 5 } };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.merge(input);
        boolean passed = output.length == 1
                && Arrays.deepEquals(output, new int[][] { { 1, 5 } });
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        int[][] input = { { 1, 4 }, { 0, 4 } };
        SolutionPractice2 s = new SolutionPractice2();
        int[][] output = s.merge(input);
        boolean passed = output.length == 1
                && Arrays.deepEquals(output, new int[][] { { 0, 4 } });
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2Linear_1() {
        int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        SolutionPractice2Linear s = new SolutionPractice2Linear();
        int[][] output = s.merge(input);
        boolean passed = output.length == 3
                && Arrays.deepEquals(output, new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } });
        System.out.println("testSolutionPractice2Linear_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2Linear_2() {
        int[][] input = { { 1, 4 }, { 4, 5 } };
        SolutionPractice2Linear s = new SolutionPractice2Linear();
        int[][] output = s.merge(input);
        boolean passed = output.length == 1
                && Arrays.deepEquals(output, new int[][] { { 1, 5 } });
        System.out.println("testSolutionPractice2Linear_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2Linear_3() {
        int[][] input = { { 1, 4 }, { 0, 4 } };
        SolutionPractice2Linear s = new SolutionPractice2Linear();
        int[][] output = s.merge(input);
        boolean passed = output.length == 1
                && Arrays.deepEquals(output, new int[][] { { 0, 4 } });
        System.out.println("testSolutionPractice2Linear_3: " + (passed ? "passed" : "failed"));
    }

}
