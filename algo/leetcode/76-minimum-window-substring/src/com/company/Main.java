package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void test1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    SolutionOptimized sol = new SolutionOptimized();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("BANC");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "a";
    String t = "a";
    SolutionOptimized sol = new SolutionOptimized();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("a");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String s = "";
    String t = "";
    SolutionOptimized sol = new SolutionOptimized();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String s = "a";
    String t = "aa";
    SolutionOptimized sol = new SolutionOptimized();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("");
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    File file = new File("input1.txt");
    String delim = "\\]\\,\\[";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String s = br.readLine();
      String t = br.readLine();
      br.close();

      Solution solution = new Solution();
      String output = solution.minWindow(s, t);
      boolean passed = output.length() == 10742;
      System.out.println("test5: " + (passed ? "passed" : "failed"));
    } catch (IOException ex) {
      System.out.println("something wrong happened");
    }
  }

  public static void test6() {
    File file = new File("input1.txt");
    String delim = "\\]\\,\\[";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String s = br.readLine();
      String t = br.readLine();
      br.close();

      SolutionOptimized solution = new SolutionOptimized();
      String output = solution.minWindow(s, t);
      boolean passed = output.length() == 10742;
      System.out.println("test6: " + (passed ? "passed" : "failed"));
    } catch (IOException ex) {
      System.out.println("something wrong happened");
    }
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
