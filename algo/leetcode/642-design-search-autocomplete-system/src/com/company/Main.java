package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    AutocompleteSystem as = new AutocompleteSystem(
        new String[]{"i love you", "island", "iroman", "i love leetcode"},
        new int[]{5, 3, 2, 2});

    List<String> output1 = as.input('i');
    List<String> output2 = as.input(' ');
    List<String> output3 = as.input('a');
    List<String> output4 = as.input('#');


  }

  public static void main(String[] args) {
    test1();
  }
}
