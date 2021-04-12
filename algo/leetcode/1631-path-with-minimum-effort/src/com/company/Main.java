package com.company;

import java.io.*;
import java.util.Random;

public class Main {

  public static void test1() {
    int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] heights = new int[][] {{2}};
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
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
    System.out.println("test3: " + (passed ? "passed" : "failed"));
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
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] heights = new int[][] {
        {1, 1000000}};


    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 999999;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
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
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[][] heights = new int[][] {
        {1,2,1,1,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,1,1,2,1}
    };
    SolutionDijkstra s = new SolutionDijkstra();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[][] heights = new int[][] {{2}};
    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    int[][] heights = new int[][] {
        {4,   3,  4,  10, 5,  5,  9,  2},
        {10,  8,  2,  10, 9,  7,  5,  6},
        {5,   8,  10, 10, 10, 7,  4,  2},
        {5,   1,  3,  1,  1,  3,  1,  9},
        {6,   4,  10, 6,  10, 9,  4,  6}};
    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 5;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    int[][] heights = new int[][] {
        {4, 2,  3},
        {5, 4,  1},
        {7, 3,  4},
        {1, 2,  5},
        {6, 1,  3},
        {5, 2,  4}};

    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    int[][] heights = new int[][] {
        {1, 1000000}};

    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 999999;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    int[][] heights = new int[][] {
        {1,2,3},
        {3,8,4},
        {5,3,5}
    };
    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 1;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    int[][] heights = new int[][] {
        {1,2,1,1,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,1,1,2,1}
    };
    SolutionUF s = new SolutionUF();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    int[][] heights = new int[][] {{2}};
    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void test23() {
    int[][] heights = new int[][] {
        {4,   3,  4,  10, 5,  5,  9,  2},
        {10,  8,  2,  10, 9,  7,  5,  6},
        {5,   8,  10, 10, 10, 7,  4,  2},
        {5,   1,  3,  1,  1,  3,  1,  9},
        {6,   4,  10, 6,  10, 9,  4,  6}};
    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 5;
    System.out.println("test23: " + (passed ? "passed" : "failed"));
  }

  public static void test24() {
    int[][] heights = new int[][] {
        {4, 2,  3},
        {5, 4,  1},
        {7, 3,  4},
        {1, 2,  5},
        {6, 1,  3},
        {5, 2,  4}};

    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test24: " + (passed ? "passed" : "failed"));
  }

  public static void test25() {
    int[][] heights = new int[][] {
        {1, 1000000}};

    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 999999;
    System.out.println("test25: " + (passed ? "passed" : "failed"));
  }

  public static void test26() {
    int[][] heights = new int[][] {
        {1,2,3},
        {3,8,4},
        {5,3,5}
    };
    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 1;
    System.out.println("test26: " + (passed ? "passed" : "failed"));
  }

  public static void test27() {
    int[][] heights = new int[][] {
        {1,2,1,1,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,2,1,2,1},
        {1,1,1,2,1}
    };
    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test27: " + (passed ? "passed" : "failed"));
  }

  public static void test28() {
    File file = new File("input4.txt");
    String delim = "\\]\\,\\[";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      int[][] input = null;
      while ((st = br.readLine()) != null) {
        st = st.replace("[[", "");
        st = st.replace("]]", "");

        String[] subarr = st.split(delim);
        int i = 0;
        for (String row : subarr) {
          String[] cols = row.split(",");
          if (input == null) {
            input = new int[subarr.length][cols.length];
          }
          int j = 0;
          for (String num : cols) {
            Integer d = Integer.parseInt(num);
            input[i][j] = d.intValue();
            j++;
          }
          i++;
        }
      }
      br.close();

      SolutionExperiment s = new SolutionExperiment();
      int output = s.minimumEffortPath(input);
      boolean passed = output == 381458;
      System.out.println("test28: " + (passed ? "passed" : "failed"));

    } catch (IOException ex) {
      System.out.println("something wrong happened");
    }
  }

  public static void test29() {
    File file = new File("input4.txt");
    String delim = "\\]\\,\\[";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      int[][] input = null;
      while ((st = br.readLine()) != null) {
        st = st.replace("[[", "");
        st = st.replace("]]", "");

        String[] subarr = st.split(delim);
        int i = 0;
        for (String row : subarr) {
          String[] cols = row.split(",");
          if (input == null) {
            input = new int[subarr.length][cols.length];
          }
          int j = 0;
          for (String num : cols) {
            Integer d = Integer.parseInt(num);
            input[i][j] = d.intValue();
            j++;
          }
          i++;
        }
      }
      br.close();

      SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
      int output = s.minimumEffortPath(input);
      boolean passed = output == 381458;
      System.out.println("test29: " + (passed ? "passed" : "failed"));

    } catch (IOException ex) {
      System.out.println("something wrong happened");
    }
  }

  public static void test30() {
    boolean testFailed = false;
    Random rand = new Random(); //instance of random class
    int N = 3;
    int upperbound = 15;
    for (int e = 0; e < 1000000; e++) {
      int[][] input = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          input[i][j] = rand.nextInt(upperbound);
        }
      }
      SolutionDijkstraOptimized s1 = new SolutionDijkstraOptimized();
      int output1 = s1.minimumEffortPath(input);
      SolutionDijkstraOptimized2 s2 = new SolutionDijkstraOptimized2();
      int output2 = s2.minimumEffortPath(input);
      if (output1 != output2) {
        System.out.println("test30: failed");
        testFailed = true;
      }
    }

    if (!testFailed) {
      System.out.println("test31: succeeded");
    }
  }

  public static void test31() {
    int[][] heights = new int[][] {
        {2, 7, 12},
        {2, 12, 13},
        {6, 5, 12}};

    SolutionDijkstraOptimized2 s = new SolutionDijkstraOptimized2();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 5;
    System.out.println("test31: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
    test17();
    test21();
    test22();
    test23();
    test25();
    test26();
    test27();
    test29();
    test30();
    test31();
    test24();

  }
}
