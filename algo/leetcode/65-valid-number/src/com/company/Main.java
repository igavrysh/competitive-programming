package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    boolean output = s.isNumber("0");
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    boolean output = s.isNumber("e");
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    boolean output = s.isNumber(".");
    boolean passed = output == false;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    boolean output = s.isNumber(".1");
    boolean passed = output == true;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    boolean output = s.isNumber("2");
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    boolean output = s.isNumber("0089");
    boolean passed = output == true;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    boolean output = s.isNumber("-0.1");
    boolean passed = output == true;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    Solution s = new Solution();
    boolean output = s.isNumber("+3.14");
    boolean passed = output == true;
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    Solution s = new Solution();
    boolean output = s.isNumber("4.");
    boolean passed = output == true;
    System.out.println("test9: " + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    Solution s = new Solution();
    boolean output = s.isNumber("-.9");
    boolean passed = output == true;
    System.out.println("test10: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    Solution s = new Solution();
    boolean output = s.isNumber("2e10");
    boolean passed = output == true;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution s = new Solution();
    boolean output = s.isNumber("-90E3");
    boolean passed = output == true;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    Solution s = new Solution();
    boolean output = s.isNumber("3e+7");
    boolean passed = output == true;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    Solution s = new Solution();
    boolean output = s.isNumber("+6e-1");
    boolean passed = output == true;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    Solution s = new Solution();
    boolean output = s.isNumber("53.5e93");
    boolean passed = output == true;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    Solution s = new Solution();
    boolean output = s.isNumber("-123.456e789");
    boolean passed = output == true;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    Solution s = new Solution();
    boolean output = s.isNumber("abc");
    boolean passed = output == false;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void test18() {
    Solution s = new Solution();
    boolean output = s.isNumber("1a");
    boolean passed = output == false;
    System.out.println("test18: " + (passed ? "passed" : "failed"));
  }

  public static void test19() {
    Solution s = new Solution();
    boolean output = s.isNumber("e3");
    boolean passed = output == false;
    System.out.println("test19: " + (passed ? "passed" : "failed"));
  }

  public static void test20() {
    Solution s = new Solution();
    boolean output = s.isNumber("99e2.5");
    boolean passed = output == false;
    System.out.println("test20: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    Solution s = new Solution();
    boolean output = s.isNumber("--6");
    boolean passed = output == false;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    Solution s = new Solution();
    boolean output = s.isNumber("-+3");
    boolean passed = output == false;
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void test23() {
    Solution s = new Solution();
    boolean output = s.isNumber("95a54e53");
    boolean passed = output == false;
    System.out.println("test23: " + (passed ? "passed" : "failed"));
  }

  public static void test24() {
    Solution s = new Solution();
    boolean output = s.isNumber(".0");
    boolean passed = output == true;
    System.out.println("test24: " + (passed ? "passed" : "failed"));
  }

  public static void test25() {
    Solution s = new Solution();
    boolean output = s.isNumber("2e0");
    boolean passed = output == true;
    System.out.println("test25: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
    test10();
    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
    test17();
    test18();
    test19();
    test20();
    test21();
    test22();
    test23();
    test24();
    test25();
  }
}
