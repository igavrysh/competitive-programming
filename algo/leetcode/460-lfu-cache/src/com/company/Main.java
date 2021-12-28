package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void test1() {
    boolean passed = true;

    LFUCache cache = new LFUCache(2);
    passed = passed
        && cache.k == 2
        && cache.dict != null
        && cache.head == null
        && cache.tail == null;
    System.out.println(getMethodName() + " - cache creation: " + (passed ? "passed" : "failed"));

    cache.put(1, 1);
    passed = passed
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 1
        && cache.head.value == 1
        && cache.tail.value == 1
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));

    cache.put(2,2);
    passed = passed
        && cache.dict.size() == 2
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 1
        && cache.dict.get(2).value == 2
        && cache.dict.get(2).useCounter == 1
        && cache.dict.get(1).prev == null
        && cache.dict.get(1).next.equals(cache.dict.get(2))
        && cache.dict.get(2).prev.equals(cache.dict.get(1))
        && cache.dict.get(2).next == null
        && cache.head.equals(cache.dict.get(1))
        && cache.tail.equals(cache.dict.get(2))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));

    int val = cache.get(1);
    passed = passed
        && val == 1
        && cache.dict.size() == 2
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 2
        && cache.dict.get(2).value == 2
        && cache.dict.get(2).useCounter == 1
        && cache.dict.get(2).prev == null
        && cache.dict.get(2).next.equals(cache.dict.get(1))
        && cache.dict.get(1).prev.equals(cache.dict.get(2))
        && cache.dict.get(1).next == null
        && cache.head.equals(cache.dict.get(2))
        && cache.tail.equals(cache.dict.get(1))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - getting element 1 - should rearrange list: " + (passed ? "passed" : "failed"));

    val = cache.get(1);
    passed = passed
        && val == 1
        && cache.dict.size() == 2
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 3
        && cache.dict.get(2).value == 2
        && cache.dict.get(2).useCounter == 1
        && cache.dict.get(2).prev == null
        && cache.dict.get(2).next.equals(cache.dict.get(1))
        && cache.dict.get(1).prev.equals(cache.dict.get(2))
        && cache.dict.get(1).next == null
        && cache.head.equals(cache.dict.get(2))
        && cache.tail.equals(cache.dict.get(1))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - getting element 1 again - no rearrangments are expected: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    passed = passed
        && cache.dict.size() == 2
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 3
        && cache.dict.get(2) == null
        && cache.dict.get(3).value == 3
        && cache.dict.get(3).useCounter == 1
        && cache.dict.get(3).prev == null
        && cache.dict.get(3).next.equals(cache.dict.get(1))
        && cache.dict.get(1).prev.equals(cache.dict.get(3))
        && cache.dict.get(1).next == null
        && cache.head.equals(cache.dict.get(3))
        && cache.tail.equals(cache.dict.get(1))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    boolean passed = true;

    LFUCache cache = new LFUCache(1);
    passed = passed
        && cache.k == 1
        && cache.dict != null
        && cache.head == null
        && cache.tail == null;
    System.out.println(getMethodName() + " - cache creation: " + (passed ? "passed" : "failed"));

    cache.put(1, 1);
    passed = passed
        && cache.dict.get(1).value == 1
        && cache.dict.get(1).useCounter == 1
        && cache.head.value == 1
        && cache.tail.value == 1
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));

    cache.put(2,2);
    passed = passed
        && cache.dict.size() == 1
        && cache.dict.get(1) == null
        && cache.dict.get(2).value == 2
        && cache.dict.get(2).useCounter == 1
        && cache.dict.get(2).prev == null
        && cache.dict.get(2).next == null
        && cache.head.equals(cache.dict.get(2))
        && cache.tail.equals(cache.dict.get(2))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));

    int val = cache.get(2);
    passed = passed
        && val == 2
        && cache.dict.size() == 1
        && cache.dict.get(2).value == 2
        && cache.dict.get(2).useCounter == 2
        && cache.dict.get(2).prev == null
        && cache.dict.get(2).next == null
        && cache.head.equals(cache.dict.get(2))
        && cache.tail.equals(cache.dict.get(2))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - getting element 2 - should rearrange list: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    passed = passed
        && cache.dict.size() == 1
        && cache.dict.get(3).value == 3
        && cache.dict.get(3).useCounter == 1
        && cache.dict.get(3).prev == null
        && cache.dict.get(3).next == null
        && cache.head.equals(cache.dict.get(3))
        && cache.tail.equals(cache.dict.get(3))
        && cache.head.prev == null
        && cache.tail.next == null;
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    boolean passed = true;

    LFUCache cache = new LFUCache(0);
    cache.put(0, 0);
    passed = passed && cache.get(0) == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));

  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
