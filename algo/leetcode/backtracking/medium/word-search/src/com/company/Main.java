package com.company;

public class Main {

  private static void test1() {
    char[][] board = new char[][]{
        new char[]{'A', 'B', 'C', 'E'},
        new char[]{'S', 'F', 'C', 'S'},
        new char[]{'A', 'D', 'E', 'E'}
    };

    Solution solution = new Solution();
    boolean passed1 = solution.exist(board, "ABCCED") == true;
    boolean passed2 = solution.exist(board, "SEE") == true;
    boolean passed3 = solution.exist(board, "ABCB") == true;
    boolean passed = passed1 && passed2 && passed3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
