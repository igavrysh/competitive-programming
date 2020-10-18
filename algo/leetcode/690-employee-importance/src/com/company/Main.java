package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    List<Employee> input = new ArrayList<>();
    Employee e1 = new Employee();
    e1.subordinates = Arrays.asList(new Integer[]{2,3});
    e1.id = 1;
    e1.importance = 5;

    Employee e2 = new Employee();
    e2.subordinates = Arrays.asList(new Integer[]{});
    e2.id = 2;
    e2.importance = 3;

    Employee e3 = new Employee();
    e3.subordinates = Arrays.asList(new Integer[]{});
    e3.id = 3;
    e3.importance = 3;

    input.add(e1);
    input.add(e2);
    input.add(e3);


    Solution s = new Solution();
    int output = s.getImportance(input, 1);
    boolean passed = output == 11;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
