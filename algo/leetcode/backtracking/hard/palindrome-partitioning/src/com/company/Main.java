package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    List<List<String>> output = solution.partition("aab");
    boolean passed = output.size() == 2;
    System.out.println("test1:" + (passed ? "true" : "false"));
  }

  public static void main(String[] args) {
    test1();
  }
}
