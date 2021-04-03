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

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    //test4();
    //test5();
    //test6();
    test7();
  }
}
