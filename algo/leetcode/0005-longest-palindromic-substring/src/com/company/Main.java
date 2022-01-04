package com.company;

public class Main {

  public static void test1() {
    String input = "babad";
    Solution solution = new Solution();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bab") || output.equals("aba");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "cbbd";
    Solution solution = new Solution();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bb");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "babaddtattarrattatddetartrateedredividerb";
    Solution solution = new Solution();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("ddtattarrattatdd");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
