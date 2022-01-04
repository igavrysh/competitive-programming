package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test1() {
        int[][] G = {{1,2}, {3}, {3}, {}};
        Solution s = new Solution();
        List<List<Integer>> output = s.allPathsSourceTarget(G);
        boolean passed = output.size() == 2
            && (Arrays.equals(output.get(0).toArray(), new Integer[]{0, 1, 3})
            || Arrays.equals(output.get(1).toArray(), new Integer[]{0, 1, 3})
        )
            && (Arrays.equals(output.get(0).toArray(), new Integer[]{0, 2, 3})
            || Arrays.equals(output.get(1).toArray(), new Integer[]{0, 2, 3})
        );
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[][] G = {{1},{}};
        Solution s = new Solution();
        List<List<Integer>> output = s.allPathsSourceTarget(G);
        boolean passed = output.size() == 1
            && Arrays.equals(output.get(0).toArray(), new Integer[]{0, 1});

        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
	      test1();
	      test3();
    }
}
