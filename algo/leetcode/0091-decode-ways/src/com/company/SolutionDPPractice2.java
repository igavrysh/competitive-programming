package com.company;

public class SolutionDPPractice2 {

    public int numDecodings(String s) {
        int n = s.length();
        int[] DP = new int[n];
        int numI = 0, prevNumI = 0;
        for (int i = 0; i < n; i++) {
            numI = s.charAt(i) - '0';
            int currDp = 0;
            if (numI >= 1 && numI <= 9 && (i == 0 || DP[i-1] > 0)) {
                currDp += (i == 0 ? 1 : DP[i-1]);
            }
            if (i >= 1) {
                int twoDigit = prevNumI*10+numI;
                if (twoDigit >= 10 && twoDigit <= 26 && (i == 1 || DP[i-2] > 0)) {
                    currDp += (i==1 ? 1 : DP[i-2]);
                } 
            }
            DP[i] = currDp;
            prevNumI = numI;
            if (i > 1 && DP[i] == 0 && DP[i-1] == 0) {
                break;
            }
        }
        return n > 0 ? DP[n-1] : 1;
    }
    
    public static void main(String[] args) {
        testSolutionDPPractice2_1();
        testSolutionDPPractice2_2();
        testSolutionDPPractice2_3();
        testSolutionDPPractice2_4();
        testSolutionDPPractice2_5();
        testSolutionDPPractice2_6();
        testSolutionDPPractice2_7();
    }

    private static void testSolutionDPPractice2_1() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("12");
        boolean passed = output == 2;
        System.out.println("testSolutionDPPractice2_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_2() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("226");
        boolean passed = output == 3;
        System.out.println("testSolutionDPPractice2_2:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_3() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("0");
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_3:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_4() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("");
        boolean passed = output == 1;
        System.out.println("testSolutionDPPractice2_4:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_5() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("10");
        boolean passed = output == 1;
        System.out.println("testSolutionDPPractice2_5:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_6() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("00");
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_6:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_7() {
        SolutionDPPractice2 s = new SolutionDPPractice2();
        int output = s.numDecodings("01");
        boolean passed = output == 0;
        System.out.println("testSolutionDPPractice2_7:" + (passed ? "passed" : "failed"));
    }
}
