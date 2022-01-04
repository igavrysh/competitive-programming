package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    int[] output = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    boolean passed = Arrays.equals(output, new int[]{2});
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    Set<Integer> expected = new HashSet(Arrays.asList(new int[]{4, 9}));
    Set<Integer> output = new HashSet(
        Arrays.asList(
            solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})
        )
    );

    boolean passed = output.contains(4)
        && output.contains(9);
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
