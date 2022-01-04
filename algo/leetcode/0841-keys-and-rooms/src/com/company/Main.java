package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(0, Arrays.asList(new Integer[] {1}));
    rooms.add(1, Arrays.asList(new Integer[] {2}));
    rooms.add(2, Arrays.asList(new Integer[] {3}));
    rooms.add(3, Arrays.asList(new Integer[] {}));
    boolean output = s.canVisitAllRooms(rooms);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(0, Arrays.asList(new Integer[] {1, 3}));
    rooms.add(1, Arrays.asList(new Integer[] {3, 0, 1}));
    rooms.add(2, Arrays.asList(new Integer[] {2}));
    rooms.add(3, Arrays.asList(new Integer[] {0}));
    boolean output = s.canVisitAllRooms(rooms);
    boolean passed = output == true;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test2();
  }
}
