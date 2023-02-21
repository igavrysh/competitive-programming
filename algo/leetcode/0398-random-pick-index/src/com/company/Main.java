package com.company;

class Main {
    public static void main(String[] args) {
        testSolutionHashMap1();
        testSolutionRandom1();
    }

    public static void testSolutionHashMap1() {
        SolutionHashMap s = new SolutionHashMap(new int[]{1,2,3,3,3});
        boolean passed = true;
        int pick1Idx = s.pick(3);
        passed = passed && (pick1Idx == 2 || pick1Idx == 3 || pick1Idx == 4);
        int pick2Idx = s.pick(1);
        passed = passed && (pick2Idx == 0);
        int pick3Idx = s.pick(3);
        passed = passed && (pick3Idx == 2 || pick3Idx == 3 || pick3Idx == 4);
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRandom1() {
        SolutionRandom s = new SolutionRandom(new int[]{1,2,3,3,3});
        boolean passed = true;
        int pick1Idx = s.pick(3);
        passed = passed && (pick1Idx == 2 || pick1Idx == 3 || pick1Idx == 4);
        int pick2Idx = s.pick(1);
        passed = passed && (pick2Idx == 0);
        int pick3Idx = s.pick(3);
        passed = passed && (pick3Idx == 2 || pick3Idx == 3 || pick3Idx == 4);
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

}