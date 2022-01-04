package com.company;

public class Main {

  public static void test1() {
    LRUCache lru = new LRUCache(2);
    lru.put(1,1);
    // [1:1]
    boolean passed = true;
    passed &= lru.KV.containsKey(1);
    passed &= lru.tail.key == 1;
    passed &= lru.head.key == 1;

    // [2:2] <-> [1:1]
    lru.put(2,2);
    passed &= lru.KV.containsKey(1);
    passed &= lru.KV.containsKey(2);
    passed &= lru.tail.key == 1;
    passed &= lru.head.key == 2;

    // [1:1] <-> [2:2]
    passed &= lru.get(1) == 1;
    passed &= lru.tail.key == 2;
    passed &= lru.head.key == 1;

    // [3:3] <-> [1:1]
    lru.put(3,3);
    passed &= lru.KV.containsKey(3);
    passed &= lru.KV.containsKey(1);
    passed &= !lru.KV.containsKey(2);
    passed &= lru.tail.key == 1;
    passed &= lru.head.key == 3;

    passed &= lru.get(2) == -1;

    // [4:4] <-> [3:3]
    lru.put(4,4);
    passed &= lru.KV.containsKey(3);
    passed &= lru.KV.containsKey(4);
    passed &= !lru.KV.containsKey(1);
    passed &= !lru.KV.containsKey(2);
    passed &= lru.tail.key == 3;
    passed &= lru.head.key == 4;

    // [3:3] <-> [4:4]
    passed &= lru.get(3) == 3;
    passed &= lru.tail.key == 4;
    passed &= lru.head.key == 3;

    // [4:4] <-> [3:3]
    passed &= lru.get(4) == 4;
    passed &= lru.tail.key == 3;
    passed &= lru.head.key == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}