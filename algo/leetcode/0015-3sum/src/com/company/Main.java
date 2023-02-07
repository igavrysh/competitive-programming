package com.company;

import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        testSolutionPractice2_6();
        testSolutionPractice2_7();
        testSolutionPractice2_8();
    }

    public static void test1() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] {});
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] { 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] {});
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 0, 0, 0, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { 0, 0, 0 }));
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 1, -1, -1, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_6() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_7() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -2, 0, 1, 1, 2 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -2, 0, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -2, 1, 1 }));
        System.out.println("testSolutionPractice2_7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_8() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 9
                && output.contains(Arrays.asList(new Integer[] { -4, 0, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -4, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, -1, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 0, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -2, -1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -2, 0, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_8:" + (passed ? "passed" : "failed"));
    }
}
