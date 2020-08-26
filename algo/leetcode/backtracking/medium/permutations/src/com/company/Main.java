package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  private static void test1() {
    int[] nums = new int[]{1, 2, 3};
    Solution solution = new Solution();
    List<List<Integer>> output = solution.permute(nums);
    boolean passed = output.size() == 6
        && output.contains(Arrays.stream(new int[]{1, 2, 3}).boxed().collect(Collectors.toList()))
        && output.contains(Arrays.stream(new int[]{1, 3, 2}).boxed().collect(Collectors.toList()))
        && output.contains(Arrays.stream(new int[]{2, 1, 3}).boxed().collect(Collectors.toList()))
        && output.contains(Arrays.stream(new int[]{2, 3, 1}).boxed().collect(Collectors.toList()))
        && output.contains(Arrays.stream(new int[]{3, 1, 2}).boxed().collect(Collectors.toList()))
        && output.contains(Arrays.stream(new int[]{3, 2, 1}).boxed().collect(Collectors.toList()));
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
