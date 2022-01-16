package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  public static void test1() {
    int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
    Solution s = new Solution();
    int output = s.minJumps(arr);
    boolean passed = output == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] arr = {7};
    Solution s = new Solution();
    int output = s.minJumps(arr);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] arr = {7,6,9,6,9,6,9,7};
    Solution s = new Solution();
    int output = s.minJumps(arr);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] arr = {6,1,9};
    Solution s = new Solution();
    int output = s.minJumps(arr);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = readInput("input1.txt");
    Solution s = new Solution();
    int output = s.minJumps(input);
    boolean passed = output == 2;
    System.out.println("test5: " + (passed ? "pasesd" : "failed"));
  }

  private static int[] readInput(String filename) {
    int[] result = new int[0];
    File file = new File(filename);
    try {
      Scanner sc = new Scanner(file);
      if (sc.hasNextLine()) {
        String input = sc.nextLine();
        List<Integer> inputList = Arrays
            .stream(input.split(","))
            .map((String str) -> { return Integer.valueOf(str); })
            .collect(Collectors.toList());
        result = new int[inputList.size()];
        int idx = 0;
        for (Integer i : inputList) {
          result[idx++] = i;
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("file not found");
    } finally {
      return result;
    }
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }


}
