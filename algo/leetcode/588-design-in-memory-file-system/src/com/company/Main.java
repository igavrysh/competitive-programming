package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    FileSystem fs = new FileSystem();
    boolean passed = true;
    List<String> names = fs.ls("/");
    passed &= names.isEmpty();
    fs.mkdir("/a/b/c");
    fs.addContentToFile("/a/b/c/d", "hello");
    names = fs.ls("/");
    passed &= names.size() == 1 && names.get(0).equals("a");
    passed &= fs.readContentFromFile("/a/b/c/d").equals("hello");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  /*
  ["FileSystem",  "mkdir",      "ls",         "ls",         "mkdir",  "ls",           "ls",             "addContentToFile",       "ls",       "ls",           "ls"]
  [[],            ["/goowmfn"], ["/goowmfn"], ["/"],        ["/z"],   ["/"],          ["/"],            ["/goowmfn/c","shetopcy"],["/z"],     ["/goowmfn/c"], ["/goowmfn"]]

  [null,          null,         [],           ["goowmfn"],  null,     ["goowmfn","z"],["goowmfn","z"],  null,                     [],         ["c"],          ["c"]]
  */

  public static void test2() {
    FileSystem fs = new FileSystem();
    List<String> names = null;
    boolean passed = true;

    fs.mkdir("/goowmfn");
    names = fs.ls("/goowmfn");
    passed &= names.size() == 0;

    names = fs.ls("/");
    passed &= names.size() == 1 && names.get(0).equals("goowmfn");

    fs.mkdir("/z");
    names = fs.ls("/");
    passed &= names.size() == 2 && names.get(0).equals("goowmfn") && names.get(1).equals("z");

    fs.addContentToFile("/goowmfn/c", "shetopcy");

    names = fs.ls("/z");
    passed &= names.size() == 0;

    names = fs.ls("/goowmfn/c");
    passed &= names.size() == 1 && names.get(0).equals("c");

    names = fs.ls("/goowmfn");
    passed &= names.size() == 1 && names.get(0).equals("c");

    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
