package com.company;

public class Main {

  public static void test1() {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 13;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] matrix = {{1}};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == false;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] matrix = {{1,1}};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == false;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] matrix = {{1,3}};
    int target = 3;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[][] matrix = {{1},{3}};
    int target = 3;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == true;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    int target = 10;
    Solution s = new Solution();
    boolean output = s.searchMatrix(matrix, target);
    boolean passed = output == true;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    /*
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
     */

    test7();
  }
}
