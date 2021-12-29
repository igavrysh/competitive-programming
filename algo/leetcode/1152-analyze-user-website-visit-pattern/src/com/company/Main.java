package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
    int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
    String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
    Solution s = new Solution();
    List<String> output = s.mostVisitedPattern(username, timestamp, website);
    boolean passed = Arrays.equals(output.toArray(), new String[]{"home","about","career"});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] username = {"ua","ua","ua","ub","ub","ub"};
    int[] timestamp = {1,2,3,4,5,6};
    String[] website = {"a","b","a","a","b","c"};
    Solution s = new Solution();
    List<String> output = s.mostVisitedPattern(username, timestamp, website);
    boolean passed = Arrays.equals(output.toArray(), new String[]{"a","b","a"});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String[] username = {"dowg","dowg","dowg"};
    int[] timestamp = {158931262,562600350,148438945};
    String[] website = {"y","loedo","y"};
    Solution s = new Solution();
    List<String> output = s.mostVisitedPattern(username, timestamp, website);
    boolean passed = Arrays.equals(output.toArray(), new String[]{"y","y","loedo"});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String[] username = {"pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd"};
    int[] timestamp = {210984153,262799291,958396687,605779010,373702273,205190519};
    String[] website = {"xgriygexlk","qs","rugydl","bkrok","canlv","cahgsobjjs"};
    Solution s = new Solution();
    List<String> output = s.mostVisitedPattern(username, timestamp, website);
    boolean passed = Arrays.equals(output.toArray(), new String[]{"cahgsobjjs","bkrok","rugydl"});
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
    int[] timestamp = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
    String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
    Solution s = new Solution();
    List<String> output = s.mostVisitedPattern(username, timestamp, website);
    boolean passed = Arrays.equals(output.toArray(), new String[]{"hibympufi","hibympufi","yljmntrclw"});
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
