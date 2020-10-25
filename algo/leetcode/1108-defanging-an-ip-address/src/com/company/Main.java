package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String output = s.defangIPaddr("1.1.1.1");
    boolean passed = output.equals("1[.]1[.]1[.]1");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
