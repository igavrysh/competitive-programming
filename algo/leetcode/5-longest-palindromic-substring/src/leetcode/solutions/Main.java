package leetcode.solutions;

import com.company.Solution;

public class Main {

  public static void test1() {
    String input = "babad";
    com.company.Solution solution = new com.company.Solution();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bab") || output.equals("aba");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "cbbd";
    com.company.Solution solution = new com.company.Solution();
    String output = solution.longestPalindrome(input);
    boolean passed = output.equals("bb");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "babaddtattarrattatddetartrateedredividerb";
    com.company.Solution solution = new Solution();
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
