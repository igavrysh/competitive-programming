package com.company;

public class Main {

  public static void test1() {
    // Your Trie object will be instantiated and called as such:
    Trie trie = new Trie();
    trie.insert("apple");
    boolean check1 = trie.search("apple") == true;    // returns true
    boolean check2 = trie.search("app") == false;     // returns false
    boolean check3 = trie.startsWith("app") == true;        // returns true
    trie.insert("app");
    boolean check4 = trie.search("app") == true;      // returns true
    boolean passed = check1 && check2 && check3 && check4;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Trie trie = new Trie();
    trie.insert("hello");
    boolean check1 = trie.search("hell") == false;
    boolean check2 = trie.search("helloa") == false;
    boolean check3 = trie.search("hello") == true;
    boolean check4 = trie.startsWith("hell") == true;
    boolean check5 = trie.startsWith("helloa") == false;
    boolean check6 = trie.startsWith("hello") == true;
    boolean passed = check1 && check2 && check3 && check4 && check4 && check5 && check6;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Trie trie = new Trie();
    trie.insert("ab");
    boolean check1 = trie.search("abc") == false;
    boolean check2 = trie.search("ab") == true;
    boolean check3 = trie.startsWith("abc") == false;
    boolean check4 = trie.startsWith("ab") == true;
    trie.insert("ab");
    boolean check5 = trie.search("abc") == false;
    boolean check6 = trie.startsWith("abc") == false;
    trie.insert("abc");
    boolean check7 = trie.search("abc") == true;
    boolean check8 = trie.startsWith("abc") == true;
    boolean passed = check1 && check2 && check3 && check4 && check4 && check5 && check6 && check7 && check8;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
