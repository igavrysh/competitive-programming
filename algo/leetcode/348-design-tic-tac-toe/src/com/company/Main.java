package com.company;

public class Main {

  public static void test1() {
    TicTacToe ticTacToe = new TicTacToe(3);
    boolean passed = true;
    passed &= ticTacToe.move(0, 0, 1) == 0;
    passed &= ticTacToe.move(0, 2, 2) == 0;
    passed &= ticTacToe.move(2, 2, 1) == 0;
    passed &= ticTacToe.move(1, 1, 2) == 0;
    passed &= ticTacToe.move(2, 0, 1) == 0;
    passed &= ticTacToe.move(1, 0, 2) == 0;
    passed &= ticTacToe.move(2, 1, 1) == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TicTacToe ticTacToe = new TicTacToe(2);
    boolean passed = true;
    passed &= ticTacToe.move(0, 1, 1) == 0;
    passed &= ticTacToe.move(1, 1, 2) == 0;
    passed &= ticTacToe.move(1, 0, 1) == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
