package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void test1() {
    String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
    String searchWord = "mouse";
    Solution s = new Solution();
    List<List<String>> output = s.suggestedProducts(products, searchWord);
    boolean passed = output.size() == 5
        && Arrays.deepEquals(output.get(0).toArray(), new String[]{"mobile","moneypot","monitor"})
        && Arrays.deepEquals(output.get(1).toArray(), new String[]{"mobile","moneypot","monitor"})
        && Arrays.deepEquals(output.get(2).toArray(), new String[]{"mouse","mousepad"})
        && Arrays.deepEquals(output.get(3).toArray(), new String[]{"mouse","mousepad"})
        && Arrays.deepEquals(output.get(4).toArray(), new String[]{"mouse","mousepad"});
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] products = {"havana"};
    String searchWord = "havana";
    Solution s = new Solution();
    List<List<String>> output = s.suggestedProducts(products, searchWord);
    boolean passed = output.size() == 6
        && Arrays.deepEquals(output.get(0).toArray(), new String[]{"havana"})
        && Arrays.deepEquals(output.get(1).toArray(), new String[]{"havana"})
        && Arrays.deepEquals(output.get(2).toArray(), new String[]{"havana"})
        && Arrays.deepEquals(output.get(3).toArray(), new String[]{"havana"})
        && Arrays.deepEquals(output.get(4).toArray(), new String[]{"havana"})
        && Arrays.deepEquals(output.get(5).toArray(), new String[]{"havana"});
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String[] products = {"bags","baggage","banner","box","cloths"};
    String searchWord = "bags";
    Solution s = new Solution();
    List<List<String>> output = s.suggestedProducts(products, searchWord);
    boolean passed = output.size() == 4
        && Arrays.deepEquals(output.get(0).toArray(), new String[]{"baggage","bags","banner"})
        && Arrays.deepEquals(output.get(1).toArray(), new String[]{"baggage","bags","banner"})
        && Arrays.deepEquals(output.get(2).toArray(), new String[]{"baggage","bags"})
        && Arrays.deepEquals(output.get(3).toArray(), new String[]{"bags"});
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String[] products = {"havana"};
    String searchWord = "tatiana";
    Solution s = new Solution();
    List<List<String>> output = s.suggestedProducts(products, searchWord);
    boolean passed = output.size() == 7
        && Arrays.deepEquals(output.get(0).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(1).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(2).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(3).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(4).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(5).toArray(), new String[]{})
        && Arrays.deepEquals(output.get(6).toArray(), new String[]{});
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
