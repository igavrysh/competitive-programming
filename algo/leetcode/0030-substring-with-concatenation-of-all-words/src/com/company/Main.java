package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    List<Integer> result = s.findSubstring("barfoothefoobarman", new String[] {"foo","bar"});
    boolean passed = result.size() == 2
        && result.contains(0)
        && result.contains(9);
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    List<Integer> result = s.findSubstring(
        "wordgoodgoodgoodbestword",
        new String[] {"word","good","best","word"});
    boolean passed = result.size() == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    List<Integer> result = s.findSubstring(
        "barfoofoobarthefoobarman",
        new String[] {"bar","foo","the"});
    boolean passed = result.size() == 3
        && result.contains(6)
        && result.contains(9)
        && result.contains(12);
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    List<Integer> result = s.findSubstring(
        "lingmindraboofooowingdingbarrwingmonkeypoundcake",
        new String[] {"fooo","barr","wing","ding","wing"});
    boolean passed = result.size() == 1
        && result.contains(13);
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
