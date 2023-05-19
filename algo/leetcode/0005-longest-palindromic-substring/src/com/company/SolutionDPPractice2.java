package com.company;

public class SolutionDPPractice2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] DP = new boolean[n];
        // [0] - length, [1] - start idx, [2] - end idx
        int[] longest = new int[]{1, 0, 0};
        boolean[] newDP = new boolean[n];
        for (int end = 0; end < n; end++ ) {
            newDP[end] = true;
            for (int start = end-1;  start >=0 ; start--) {
                newDP[start] = (end-1<start+1 ? true : DP[start+1]) 
                    && s.charAt(start) == s.charAt(end);
                if (newDP[start] && end-start+1 > longest[0]) {
                    longest = new int[]{end-start+1, start, end};
                }
            }
            boolean[] tmp = DP;
            DP = newDP;
            newDP = tmp;
        }
        return s.substring(longest[1], longest[2]+1);
    }

    public static void main(String[] args) {
        testSolutionDPPractice2_1();
        testSolutionDPPractice2_2();
        testSolutionDPPractice2_3();
    }

    private static void testSolutionDPPractice2_1() {
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        String s = "babad";
        String exepectedOutput = "bab";
        String output = sol.longestPalindrome(s);
        boolean passed = output.equals(exepectedOutput);
        System.out.println("testSolutionDPPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_2() {
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        String s = "cbbd";
        String exepectedOutput = "bb";
        String output = sol.longestPalindrome(s);
        boolean passed = output.equals(exepectedOutput);
        System.out.println("testSolutionDPPractice2_2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_3() {
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        String s = "a";
        String exepectedOutput = "a";
        String output = sol.longestPalindrome(s);
        boolean passed = output.equals(exepectedOutput);
        System.out.println("testSolutionDPPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
