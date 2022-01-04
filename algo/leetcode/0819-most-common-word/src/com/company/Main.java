package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    var paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};
    String output = solution.mostCommonWord(paragraph, banned);
    System.out.println(output.equals("ball") == true ? "test passed" : "test failed");
  }

  public static void test2() {
    Solution solution = new Solution();
    var paragraph = "Bob. hIt, baLl";
    String[] banned = {"bob", "hit"};
    String output = solution.mostCommonWord(paragraph, banned);
    System.out.println(output.equals("ball") == true ? "test passed" : "test failed");
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
