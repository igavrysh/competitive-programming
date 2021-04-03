package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void test1() {
    int[] input = {3,3,3,3,5,5,5,2,2,7};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {7,7,7,7,7,7};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {1, 9};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {100,100,3,7};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {1,2,3,4,5,6,7,8,9,10};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] input = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    File file = new File("input1.txt");
    List<Integer> ints = new ArrayList<>();
    try {
      Scanner myReader = new Scanner(file);
      myReader.useDelimiter(",");
      while(myReader.hasNextInt()) {
        Integer val = myReader.nextInt();
        ints.add(val);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    int[] input = new int[ints.size()];
    for (int i = 0; i < ints.size(); i++) {
      input[i] = ints.get(i);
    }
    Solution s = new Solution();
    int output = s.minSetSize(input);
    boolean passed = output == 31595;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[] input = {3,3,3,3,5,5,5,2,2,7};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 2;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[] input = {7,7,7,7,7,7};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    int[] input = {1, 9};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    int[] input = {100,100,3,7};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    int[] input = {1,2,3,4,5,6,7,8,9,10};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    int[] input = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    File file = new File("input1.txt");
    List<Integer> ints = new ArrayList<>();
    try {
      Scanner myReader = new Scanner(file);
      myReader.useDelimiter(",");
      while(myReader.hasNextInt()) {
        Integer val = myReader.nextInt();
        ints.add(val);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    int[] input = new int[ints.size()];
    for (int i = 0; i < ints.size(); i++) {
      input[i] = ints.get(i);
    }
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.minSetSize(input);
    boolean passed = output == 31595;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    int[] input = {3,3,3,3,5,5,5,2,2,7};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 2;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    int[] input = {7,7,7,7,7,7};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void test23() {
    int[] input = {1, 9};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test23: " + (passed ? "passed" : "failed"));
  }

  public static void test24() {
    int[] input = {100,100,3,7};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 1;
    System.out.println("test24: " + (passed ? "passed" : "failed"));
  }

  public static void test25() {
    int[] input = {1,2,3,4,5,6,7,8,9,10};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test25: " + (passed ? "passed" : "failed"));
  }

  public static void test26() {
    int[] input = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 5;
    System.out.println("test26: " + (passed ? "passed" : "failed"));
  }

  public static void test27() {
    File file = new File("input1.txt");
    List<Integer> ints = new ArrayList<>();
    try {
      Scanner myReader = new Scanner(file);
      myReader.useDelimiter(",");
      while(myReader.hasNextInt()) {
        Integer val = myReader.nextInt();
        ints.add(val);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    int[] input = new int[ints.size()];
    for (int i = 0; i < ints.size(); i++) {
      input[i] = ints.get(i);
    }
    SolutionMemoryOptimized2 s = new SolutionMemoryOptimized2();
    int output = s.minSetSize(input);
    boolean passed = output == 31595;
    System.out.println("test27: " + (passed ? "passed" : "failed"));
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
    test24();
    test25();
    test26();
    test27();
  }
}
