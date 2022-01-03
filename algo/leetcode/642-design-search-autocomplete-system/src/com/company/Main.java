package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    AutocompleteSystem as = new AutocompleteSystem(
        new String[]{"i love you", "island", "iroman", "i love leetcode"},
        new int[]{5, 3, 2, 2});

    boolean passed = true;
    List<String> output1 = as.input('i');
    passed = passed && Arrays.deepEquals(output1.toArray(), new String[]{"i love you", "island", "i love leetcode"});

    List<String> output2 = as.input(' ');
    passed = passed && Arrays.deepEquals(output2.toArray(), new String[]{"i love you", "i love leetcode"});

    List<String> output3 = as.input('a');
    passed = passed && Arrays.deepEquals(output3.toArray(), new String[]{});

    List<String> output4 = as.input('#');
    passed = passed && Arrays.deepEquals(output4.toArray(), new String[]{});

    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    AutocompleteSystem as = new AutocompleteSystem(
        new String[]{"i love you","island","iroman","i love leetcode"},
        new int[]{5, 3, 2, 2});

    boolean passed = true;


    List<String> output1 = as.input('i');
    passed = passed && Arrays.deepEquals(output1.toArray(), new String[]{"i love you", "island", "i love leetcode"});

    List<String> output2 = as.input(' ');
    passed = passed && Arrays.deepEquals(output2.toArray(), new String[]{"i love you", "i love leetcode"});

    List<String> output3 = as.input('a');
    passed = passed && Arrays.deepEquals(output3.toArray(), new String[]{});

    List<String> output4 = as.input('#');
    passed = passed && Arrays.deepEquals(output4.toArray(), new String[]{});


    List<String> output5 = as.input('i');
    passed = passed && Arrays.deepEquals(output5.toArray(), new String[]{"i love you", "island", "i love leetcode"});

    List<String> output6 = as.input(' ');
    passed = passed && Arrays.deepEquals(output6.toArray(), new String[]{"i love you", "i love leetcode", "i a"});

    List<String> output7 = as.input('a');
    passed = passed && Arrays.deepEquals(output7.toArray(), new String[]{"i a"});

    List<String> output8 = as.input('#');
    passed = passed && Arrays.deepEquals(output8.toArray(), new String[]{});


    List<String> output9 = as.input('i');
    passed = passed && Arrays.deepEquals(output9.toArray(), new String[]{"i love you","island","i a"});

    List<String> output10 = as.input(' ');
    passed = passed && Arrays.deepEquals(output10.toArray(), new String[]{"i love you","i a","i love leetcode"});

    List<String> output11 = as.input('a');
    passed = passed && Arrays.deepEquals(output11.toArray(), new String[]{"i a"});

    List<String> output12 = as.input('#');
    passed = passed && Arrays.deepEquals(output12.toArray(), new String[]{});


    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    AutocompleteSystem as = new AutocompleteSystem(
        new String[]{"abc","abbc","a"},
        new int[]{3,3,3});

    boolean passed = true;

    List<String> output1 = as.input('b');
    passed = passed && Arrays.deepEquals(output1.toArray(), new String[]{});

    List<String> output2 = as.input('c');
    passed = passed && Arrays.deepEquals(output2.toArray(), new String[]{});

    List<String> output3 = as.input('#');
    passed = passed && Arrays.deepEquals(output3.toArray(), new String[]{});


    List<String> output4 = as.input('b');
    passed = passed && Arrays.deepEquals(output4.toArray(), new String[]{"bc"});

    List<String> output5 = as.input('c');
    passed = passed && Arrays.deepEquals(output5.toArray(), new String[]{"bc"});

    List<String> output6 = as.input('#');
    passed = passed && Arrays.deepEquals(output6.toArray(), new String[]{});


    List<String> output7 = as.input('a');
    passed = passed && Arrays.deepEquals(output7.toArray(), new String[]{"a","abbc","abc"});

    List<String> output8 = as.input('b');
    passed = passed && Arrays.deepEquals(output8.toArray(), new String[]{"abbc","abc"});

    List<String> output9 = as.input('c');
    passed = passed && Arrays.deepEquals(output9.toArray(), new String[]{"abc"});

    List<String> output10 = as.input('#');
    passed = passed && Arrays.deepEquals(output10.toArray(), new String[]{});


    List<String> output11 = as.input('a');
    passed = passed && Arrays.deepEquals(output11.toArray(), new String[]{"abc","a","abbc",});

    List<String> output12 = as.input('b');
    passed = passed && Arrays.deepEquals(output12.toArray(), new String[]{"abc","abbc"});

    List<String> output13 = as.input('c');
    passed = passed && Arrays.deepEquals(output13.toArray(), new String[]{"abc"});

    List<String> output14 = as.input('#');
    passed = passed && Arrays.deepEquals(output14.toArray(), new String[]{});

    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
