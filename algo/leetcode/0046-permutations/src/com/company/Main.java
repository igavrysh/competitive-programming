package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test1() {
        Solution solution = new Solution();
        List<List<Integer>> output = solution.permute(new int[] { 1, 2, 3 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1, 2, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 3, 2 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 3, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 2, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 1, 2 }));
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
    }
}
