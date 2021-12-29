package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    Solution s = new Solution();
    String[] output = s.reorderLogFiles(logs);
    boolean passed = Arrays.equals(output, new String[]{
        "let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    Solution s = new Solution();
    String[] output = s.reorderLogFiles(logs);
    boolean passed = Arrays.equals(output, new String[]{
        "g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
