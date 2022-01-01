package com.company;

public class Main {

  public static void test1() {
    String[] input = {"3","4","+","2","*","7","/"};
    TreeBuilder b = new TreeBuilder();
    Node n = b.buildTree(input);
    int result = n.evaluate();
    boolean passed = result == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }


  public static void test2() {
    String[] input = {"4","5","2","7","+","-","*"};
    TreeBuilder b = new TreeBuilder();
    Node n = b.buildTree(input);
    int result = n.evaluate();
    boolean passed = result == -16;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
