package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    List<List<String>> output = solution.partition("aab");
    boolean passed = output.contains(Arrays.asList(new String[]{"a", "a", "b"}))
        && output.contains(Arrays.asList(new String[]{"aa", "b"}));
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
