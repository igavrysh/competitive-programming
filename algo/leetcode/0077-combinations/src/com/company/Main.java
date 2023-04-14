package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public static void test1() {
        Solution s = new Solution();
        List<List<Integer>> output = s.combine(4, 2);
        boolean passed = output.size() == 6
                && output.stream().map((List<Integer> l) -> {
                    return Arrays.equals(l.toArray(), new Integer[] { 2, 4 })
                            || Arrays.equals(l.toArray(), new Integer[] { 3, 4 })
                            || Arrays.equals(l.toArray(), new Integer[] { 2, 3 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 2 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 3 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 4 });
                }).reduce(true, (Boolean subtotal, Boolean element) -> {
                    return subtotal && element;
                }).equals(true);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        List<List<Integer>> output = s.combine(1, 1);
        boolean passed = output.size() == 1
                && output.stream().map((List<Integer> l) -> {
                    return Arrays.equals(l.toArray(), new Integer[] { 1 });
                }).reduce(true, (Boolean subtotal, Boolean element) -> {
                    return subtotal && element;
                }).equals(true);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.combine(4, 2);
        boolean passed = output.size() == 6
                && output.stream().map((List<Integer> l) -> {
                    return Arrays.equals(l.toArray(), new Integer[] { 2, 4 })
                            || Arrays.equals(l.toArray(), new Integer[] { 3, 4 })
                            || Arrays.equals(l.toArray(), new Integer[] { 2, 3 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 2 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 3 })
                            || Arrays.equals(l.toArray(), new Integer[] { 1, 4 });
                }).reduce(true, (Boolean subtotal, Boolean element) -> {
                    return subtotal && element;
                }).equals(true);
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.combine(1, 1);
        boolean passed = output.size() == 1
                && output.stream().map((List<Integer> l) -> {
                    return Arrays.equals(l.toArray(), new Integer[] { 1 });
                }).reduce(true, (Boolean subtotal, Boolean element) -> {
                    return subtotal && element;
                }).equals(true);
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }
}
