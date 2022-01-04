package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String output = s.numberToWords(1);
    boolean passed = output.equals("One");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    String output = s.numberToWords(0);
    boolean passed = output.equals("Zero");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    String output = s.numberToWords(111);
    boolean passed = output.equals("One Hundred Eleven");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    String output = s.numberToWords(120);
    boolean passed = output.equals("One Hundred Twenty");
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    String output = s.numberToWords(121);
    boolean passed = output.equals("One Hundred Twenty One");
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    String output = s.numberToWords(199);
    boolean passed = output.equals("One Hundred Ninety Nine");
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    String output = s.numberToWords(101);
    boolean passed = output.equals("One Hundred One");
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    Solution s = new Solution();
    String output = s.numberToWords(1001);
    boolean passed = output.equals("One Thousand One");
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    Solution s = new Solution();
    String output = s.numberToWords(981001);
    boolean passed = output.equals("Nine Hundred Eighty One Thousand One");
    System.out.println("test9: " + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    Solution s = new Solution();
    String output = s.numberToWords(123);
    boolean passed = output.equals("One Hundred Twenty Three");
    System.out.println("test10: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    Solution s = new Solution();
    String output = s.numberToWords(12345);
    boolean passed = output.equals("Twelve Thousand Three Hundred Forty Five");
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution s = new Solution();
    String output = s.numberToWords(1234567);
    boolean passed = output.equals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    Solution s = new Solution();
    String output = s.numberToWords(1234567891);
    boolean passed = output.equals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One");
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    Solution s = new Solution();
    String output = s.numberToWords(1000010);
    boolean passed = output.equals("One Million Ten");
    System.out.println("test14: " + (passed ? "passed" : "failed"));
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
  }

}
