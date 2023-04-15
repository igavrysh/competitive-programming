package com.company;

public class Main {

    public static void main(String[] args) {    
        testSolution_1();
        testSolution_2();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        
    }

    public static void testSolution_1() {
        int[][] intervals = { { 5, 10 }, { 0, 30 }, { 15, 20 } };
        Solution s = new Solution();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 2;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[][] intervals = { { 1, 10 }, { 2, 7 }, { 3, 19 }, { 8, 12 }, { 10, 20 }, { 11, 30 } };
        Solution s = new Solution();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 4;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        int[][] intervals = { { 5, 10 }, { 0, 30 }, { 15, 20 } };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 2;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[][] intervals = { { 1, 10 }, { 2, 7 }, { 3, 19 }, { 8, 12 }, { 10, 20 }, { 11, 30 } };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 4;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        int[][] intervals = { { 1, 13 }, { 13, 15 } };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        int[][] intervals = { { 1, 13 }, { 2, 13 }, {13, 15} };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 2;
        System.out.println("testSolutionPractice2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, {15, 20} };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 2;
        System.out.println("testSolutionPractice2_5: " + (passed ? "passed" : "failed"));
    }
}
