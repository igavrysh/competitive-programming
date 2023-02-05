package com.company;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        testSolutionSimple1();
        testSolutionSimple2();
        testSolutionSimple3();

        testSolutionMonotonicStack1();
        testSolutionMonotonicStack2();
        testSolutionMonotonicStack3();
    }

    public static void testSolutionSimple1() {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        SolutionSimple s = new SolutionSimple();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,4,2,1,1,0,0});
        System.out.println("testSolutionSimple1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSimple2() {
        int[] temperatures = new int[]{30,40,50,60};
        SolutionSimple s = new SolutionSimple();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,1,0});
        System.out.println("testSolutionSimple2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSimple3() {
        int[] temperatures = new int[]{30,60,90};
        SolutionSimple s = new SolutionSimple();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,0});
        System.out.println("testSolutionSimple3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonotonicStack1() {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        SolutionMonotonicStack s = new SolutionMonotonicStack();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,4,2,1,1,0,0});
        System.out.println("testSolutionMonotonicStack1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonotonicStack2() {
        int[] temperatures = new int[]{30,40,50,60};
        SolutionMonotonicStack s = new SolutionMonotonicStack();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,1,0});
        System.out.println("testSolutionMonotonicStack2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonotonicStack3() {
        int[] temperatures = new int[]{30,60,90};
        SolutionMonotonicStack s = new SolutionMonotonicStack();
        int[] output = s.dailyTemperatures(temperatures);
        boolean passed = Arrays.equals(output, new int[]{1,1,0});
        System.out.println("testSolutionMonotonicStack3: " + (passed ? "passed" : "failed"));
    }

}