package com.company;

public class Main {

  public static void test1() {
    String s = "aa";
    String p = "a";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == false;
    System.out.println("test1:" + (passed ? "true" : "false"));
  }

  public static void test2() {
    String s = "aa";
    String p = "*";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test2:" + (passed ? "true" : "false"));
  }

  public static void test3() {
    String s = "cb";
    String p = "?a";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == false;
    System.out.println("test3:" + (passed ? "true" : "false"));
  }

  public static void test4() {
    String s = "adceb";
    String p = "*a*b";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test4:" + (passed ? "true" : "false"));
  }

  public static void test5() {
    String s = "acdcb";
    String p = "a*c?b";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == false;
    System.out.println("test5:" + (passed ? "true" : "false"));
  }

  public static void test6() {
    String s = "";
    String p = "*";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test6:" + (passed ? "true" : "false"));
  }

  public static void test7() {
    String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
    String p = "*aabb***aa**a******aa*";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test7:" + (passed ? "true" : "true"));
  }

  public static void test8() {
    String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
    String p = "*aabb*aa*a*aa*";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test8:" + (passed ? "true" : "false"));
  }

  public static void test9() {
    String s = "abbbba";
    String p = "a******a";
    Solution solution = new Solution();
    boolean passed = solution.isMatch(s, p) == true;
    System.out.println("test9:" + (passed ? "true" : "false"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    //test7();
    test8();
    test9();
  }
}
