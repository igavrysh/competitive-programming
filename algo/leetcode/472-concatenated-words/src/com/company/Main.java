package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    Solution s = new Solution();
    List<String> output = s.findAllConcatenatedWordsInADict(words);
    boolean passed = output.containsAll(Arrays.asList(new String[]{"catsdogcats","dogcatsdog","ratcatdogcat"}));
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] words = {""};
    Solution s = new Solution();
    List<String> output = s.findAllConcatenatedWordsInADict(words);
    boolean passed = output.containsAll(Arrays.asList(new String[]{""}));
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
  }
}
