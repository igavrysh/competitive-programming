package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionHeapNonRecursive {
    public List<List<Integer>> permute(int[] A) {
        List<List<Integer>> output = new ArrayList<>();
        int[] c = new int[A.length];
        output(output, A);

        int i = 1;
        int n = A.length;
        while (i < n) {
            if (c[i] < i) {
                if (i%2==0) {
                    swap(A, 0, i);
                } else {
                    swap(A, c[i], i);
                }
                output(output, A);
                c[i] += 1;
                i = 1;
            } else {
                c[i] = 0;
                i += 1;
            }
        }
        return output;
    }

    private void output(List<List<Integer>> output, int[] A) {
        List<Integer> o = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            o.add(A[i]);
        }
        output.add(o);
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        testSolutionHeapNonRecursive_1();
        testSolutionHeapNonRecursive_2();
        testSolutionHeapNonRecursive_3();
    }

    public static void testSolutionHeapNonRecursive_1() {
        SolutionHeapNonRecursive solution = new SolutionHeapNonRecursive();
        List<List<Integer>> output = solution.permute(new int[] { 1, 2, 3 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1, 2, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 3, 2 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 3, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 2, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 1, 2 }));
        System.out.println("testSolutionHeapNonRecursive_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHeapNonRecursive_2() {
        SolutionHeapNonRecursive solution = new SolutionHeapNonRecursive();
        List<List<Integer>> output = solution.permute(new int[] { 0, 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 0, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 0 }));
        System.out.println("testSolutionHeapNonRecursive_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHeapNonRecursive_3() {
        SolutionHeapNonRecursive solution = new SolutionHeapNonRecursive();
        List<List<Integer>> output = solution.permute(new int[] { 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1 }));
        System.out.println("testSolutionHeapNonRecursive_3:" + (passed ? "passed" : "failed"));
    }
}
