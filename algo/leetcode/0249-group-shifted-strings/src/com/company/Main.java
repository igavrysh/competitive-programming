package src.com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void test1() {
    String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
    Solution s = new Solution();
    List<List<String>> output = s.groupStrings(strings);
    boolean passed = output.size() == 4
      && output.stream()
      .map((List<String> m) -> Arrays.deepEquals(m.toArray(), new String[]{"acef"})
            || Arrays.deepEquals(m.toArray(), new String[]{"a","z"})
            || Arrays.deepEquals(m.toArray(), new String[]{"abc","bcd","xyz"})
            || Arrays.deepEquals(m.toArray(), new String[]{"az","ba"}))
      .reduce(true, (Boolean acc, Boolean value) -> acc && value)
      .booleanValue();
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] strings = {"a"};
    Solution s = new Solution();
    List<List<String>> output = s.groupStrings(strings);
    boolean passed = output.size() == 1
      && output.stream()
      .map((List<String> m) -> Arrays.deepEquals(m.toArray(), new String[]{"acef"})
            || Arrays.deepEquals(m.toArray(), new String[]{"a"}))
      .reduce(true, (Boolean acc, Boolean value) -> acc && value)
      .booleanValue();
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
