package com.company;

public class Main {

  public static void test1() {
    String num1 = "123";
    String num2 = "456";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("56088");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String num1 = "2";
    String num2 = "3";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("6");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String num1 = "2";
    String num2 = "0";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("0");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String num1 = "9";
    String num2 = "9";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("81");
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String num1 = "99";
    String num2 = "99";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("9801");
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    String num1 = "999";
    String num2 = "99";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("98901");
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    String num1 = "777";
    String num2 = "0";
    Solution s = new Solution();
    String output = s.multiply(num1, num2);
    boolean passed = output.equals("0");
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
  }
}
