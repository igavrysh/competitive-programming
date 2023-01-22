package com.company;

class Main {
    public static void main(String[] args) {
        testSolutionRecursive_1();
        testSolutionRecursive_2();
        // Time Limit Exceeded
        //testSolutionRecursive_3();

        testSolutionRecursiveMemoization_1();
        testSolutionRecursiveMemoization_2();
        testSolutionRecursiveMemoization_3();

        testSolutionIterative_1();
        testSolutionIterative_2();
        testSolutionIterative_3();

        testSolutionIterativeOptimized_1();
        testSolutionIterativeOptimized_2();
        testSolutionIterativeOptimized_3();
    }

    public static void testSolutionRecursive_1() {
        SolutionRecursive s = new SolutionRecursive();
        int output = s.numDistinct("rabbbit", "rabbit");
        boolean passed = output == 3;
        System.out.println("testSolutionRecursive_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRecursive_2() {
        SolutionRecursive s = new SolutionRecursive();
        int output = s.numDistinct("babgbag", "bag");
        boolean passed = output == 5;
        System.out.println("testSolutionRecursive_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRecursive_3() {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        SolutionRecursive solution = new SolutionRecursive();
        int output = solution.numDistinct(s, t);
        boolean passed = output == 5;
        System.out.println("testSolutionRecursive_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRecursiveMemoization_1() {
        SolutionRecursiveMemoization s = new SolutionRecursiveMemoization();
        int output = s.numDistinct("rabbbit", "rabbit");
        boolean passed = output == 3;
        System.out.println("testSolutionRecursiveMemoization_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRecursiveMemoization_2() {
        SolutionRecursiveMemoization s = new SolutionRecursiveMemoization();
        int output = s.numDistinct("babgbag", "bag");
        boolean passed = output == 5;
        System.out.println("testSolutionRecursiveMemoization_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionRecursiveMemoization_3() {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        SolutionRecursiveMemoization solution = new SolutionRecursiveMemoization();
        int output = solution.numDistinct(s, t);
        boolean passed = output == 700531452;
        System.out.println("testSolutionRecursiveMemoization_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterative_1() {
        SolutionIterative s = new SolutionIterative();
        int output = s.numDistinct("rabbbit", "rabbit");
        boolean passed = output == 3;
        System.out.println("testSolutionIterative_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterative_2() {
        SolutionIterative s = new SolutionIterative();
        int output = s.numDistinct("babgbag", "bag");
        boolean passed = output == 5;
        System.out.println("testSolutionIterative_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterative_3() {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        SolutionIterative solution = new SolutionIterative();
        int output = solution.numDistinct(s, t);
        boolean passed = output == 700531452;
        System.out.println("testSolutionIterative_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterativeOptimized_1() {
        SolutionIterativeOptimized s = new SolutionIterativeOptimized();
        int output = s.numDistinct("rabbbit", "rabbit");
        boolean passed = output == 3;
        System.out.println("testSolutionIterativeOptimized_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterativeOptimized_2() {
        SolutionIterativeOptimized s = new SolutionIterativeOptimized();
        int output = s.numDistinct("babgbag", "bag");
        boolean passed = output == 5;
        System.out.println("testSolutionIterativeOptimized_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionIterativeOptimized_3() {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        SolutionIterativeOptimized solution = new SolutionIterativeOptimized();
        int output = solution.numDistinct(s, t);
        boolean passed = output == 700531452;
        System.out.println("testSolutionIterativeOptimized_3: " + (passed ? "passed" : "failed"));
    }
}