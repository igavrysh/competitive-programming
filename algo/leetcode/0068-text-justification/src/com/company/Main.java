package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 16;
    Solution s = new Solution();
    List<String> output = s.fullJustify(words, maxWidth);
    boolean passed = output.size() == 3
        && output.get(0).equals("This    is    an")
        && output.get(1).equals("example  of text")
        && output.get(2).equals("justification.  ");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] words = {"What","must","be","acknowledgment","shall","be"};
    int maxWidth = 16;
    Solution s = new Solution();
    List<String> output = s.fullJustify(words, maxWidth);
    boolean passed = output.size() == 3
        && output.get(0).equals("What   must   be")
        && output.get(1).equals("acknowledgment  ")
        && output.get(2).equals("shall be        ");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to",
        "a","computer.","Art","is","everything","else","we","do"};
    int maxWidth = 20;
    Solution s = new Solution();
    List<String> output = s.fullJustify(words, maxWidth);
    boolean passed = output.size() == 6
        && output.get(0).equals("Science  is  what we")
        && output.get(1).equals("understand      well")
        && output.get(2).equals("enough to explain to")
        && output.get(3).equals("a  computer.  Art is")
        && output.get(4).equals("everything  else  we")
        && output.get(5).equals("do                  ");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
