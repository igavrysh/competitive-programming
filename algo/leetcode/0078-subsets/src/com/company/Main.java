package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] nums = new int[] { 1, 2, 3 };
        Solution solution = new Solution();
        List<List<Integer>> output = solution.subsets(nums);
        boolean passed = output.size() == 8
                && output.contains(IntStream.of(new int[] { 1 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 2 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 2 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 2, 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));

        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] nums = new int[] { 1, 2, 3 };
        SolutionWithStartIndex solution = new SolutionWithStartIndex();
        List<List<Integer>> output = solution.subsets(nums);
        boolean passed = output.size() == 8
                && output.contains(IntStream.of(new int[] { 1 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 2 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 2 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] { 1, 2, 3 }).boxed().collect(Collectors.toList()))
                && output.contains(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));

        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }
}
