package com.company;

public class Main {

  public static void test1(){
    String str = "leetcode";
    SolutionArray s = new SolutionArray();
    int output = s.firstUniqChar(str);
    boolean passed = output == 0;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2(){
    String str = "loveleetcode";
    SolutionArray s = new SolutionArray();
    int output = s.firstUniqChar(str);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3(){
    String str = "aabb";
    SolutionArray s = new SolutionArray();
    int output = s.firstUniqChar(str);
    boolean passed = output == -1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4(){
    String str = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
    SolutionArray s = new SolutionArray();
    int output = s.firstUniqChar(str);
    boolean passed = output == 61;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }

}
