package com.company;

import java.util.PriorityQueue;

public class Main {

  public static void test1() {
    int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] heights = new int[][] {{2}};
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] heights = new int[][] {
        {4,   3,  4,  10, 5,  5,  9,  2},
        {10,  8,  2,  10, 9,  7,  5,  6},
        {5,   8,  10, 10, 10, 7,  4,  2},
        {5,   1,  3,  1,  1,  3,  1,  9},
        {6,   4,  10, 6,  10, 9,  4,  6}};
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 5;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] heights = new int[][] {
        {4, 2,  3},
        {5, 4,  1},
        {7, 3,  4},
        {1, 2,  5},
        {6, 1,  3},
        {5, 2,  4}};

    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] heights = new int[][] {
        {1, 1000000}};


    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 999999;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[][] heights = new int[][] {
        {1,2,3},
        {3,8,4},
        {5,3,5}
    };
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 1;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[][] heights = new int[][] {
        {1,2,1,1,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,1,1,2,1}
    };
    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();

    Integer[] D = new Integer[] {30,25,13};
    PriorityQueue<Integer> q = new PriorityQueue<>((Integer a, Integer b) -> {
      return D[b] - D[a];
    });
    q.add(0);
    q.add(1);
    q.add(2);

    q.remove(1);

    int t = 1;
  }
}
