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
    boolean passed = output.equals("bb");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void testDP1() {
    String input = "aa";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("aa");
    System.out.println("testDP1:" + (passed ? "passed" : "failed"));
  }

  public static void testDP2() {
    String input = "babad";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bab") || output.equals("aba");
    System.out.println("testDP2:" + (passed ? "passed" : "failed"));
  }

  public static void testDP3() {
    String input = "cbbd";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bb");
    System.out.println("testDP3:" + (passed ? "passed" : "failed"));
  }

  public static void testDP4() {
    String input = "a";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("a");
    System.out.println("testDP4:" + (passed ? "passed" : "failed"));
  }

  public static void testDP5() {
    String input = "babaddtattarrattatddetartrateedredividerb";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("ddtattarrattatdd");
    System.out.println("testDP5:" + (passed ? "passed" : "failed"));
  }

  public static void testDP6() {
    String input = "aaaa";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("aaaa");
    System.out.println("testDP6:" + (passed ? "passed" : "failed"));
  }

  public static void testDP7() {
    String input = "aaaaa";
    SolutionDP solution = new SolutionDP();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("aaaaa");
    System.out.println("testDP7:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    /*
    test1();
    test2();
    test3();

    testDP1();
    testDP2();
    testDP3();
    testDP4();
    testDP5();
    testDP6();
     */

    testDP7();

  }
}
