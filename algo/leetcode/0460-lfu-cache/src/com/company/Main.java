package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void testLFUCacheTwoHashMapsNMinFqVar1() {
    boolean passed = true;

    LFUCacheTwoHashMapsNMinFqVar cache = new LFUCacheTwoHashMapsNMinFqVar(2);
    passed = passed
        && cache.capacity == 2
        && cache.nodes != null
        && cache.fq != null
        && cache.currSize == 0;
    System.out.println(getMethodName() + " - cache creation: " + (passed ? "passed" : "failed"));


    cache.put(1, 1);
    passed = passed
        && cache.nodes.size() == 1
        && cache.fq.size() == 1
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 1
        && cache.fq.get(1).getSize() == 1
        && cache.fq.get(1).sentinel.next.prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next.next == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next.value == 1;
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));


    cache.put(2,2);
    passed = passed
        && cache.minFQ == 1
        && cache.capacity == 2
        && cache.currSize == 2
        && cache.nodes.size() == 2
        && cache.fq.size() == 1
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 1
        && cache.nodes.get(2).value == 2
        && cache.nodes.get(2).useCounter == 1
        && cache.nodes.get(1).prev == cache.nodes.get(2)
        && cache.nodes.get(1).next == cache.fq.get(1).sentinel
        && cache.nodes.get(2).prev == cache.fq.get(1).sentinel
        && cache.nodes.get(2).next == cache.nodes.get(1);
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));


    int val = cache.get(1);
    passed = passed
        && val == 1
        && cache.minFQ == 1
        && cache.capacity == 2
        && cache.currSize == 2
        && cache.nodes.size() == 2
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 2
        && cache.nodes.get(2).value == 2
        && cache.nodes.get(2).useCounter == 1
        && cache.fq.size() == 2
        && cache.fq.get(1).size == 1
        && cache.fq.get(2).size == 1
        && cache.nodes.get(1).next == cache.fq.get(2).sentinel
        && cache.nodes.get(1).prev == cache.fq.get(2).sentinel
        && cache.fq.get(2).sentinel.next == cache.nodes.get(1)
        && cache.fq.get(2).sentinel.prev == cache.nodes.get(1)
        && cache.nodes.get(2).next == cache.fq.get(1).sentinel
        && cache.nodes.get(2).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(2)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(2);

    System.out.println(getMethodName() + " - getting element 1 - should rearrange list: " + (passed ? "passed" : "failed"));

    val = cache.get(1);
    passed = passed
        && val == 1
        && cache.minFQ == 1
        && cache.capacity == 2
        && cache.currSize == 2
        && cache.nodes.size() == 2
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 3
        && cache.nodes.get(2).value == 2
        && cache.nodes.get(2).useCounter == 1
        && cache.fq.size() == 2
        && cache.fq.get(1).size == 1
        && cache.fq.get(3).size == 1
        && cache.nodes.get(1).next == cache.fq.get(3).sentinel
        && cache.nodes.get(1).prev == cache.fq.get(3).sentinel
        && cache.fq.get(3).sentinel.next == cache.nodes.get(1)
        && cache.fq.get(3).sentinel.prev == cache.nodes.get(1)
        && cache.nodes.get(2).next == cache.fq.get(1).sentinel
        && cache.nodes.get(2).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(2)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(2);
    System.out.println(getMethodName() + " - getting element 1 again - no rearrangments are expected: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    passed = passed
        && cache.nodes.size() == 2
        && cache.minFQ == 1
        && cache.capacity == 2
        && cache.currSize == 2
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 3
        && cache.nodes.get(2) == null
        && cache.nodes.get(3).value == 3
        && cache.nodes.get(3).useCounter == 1
        && cache.fq.size() == 2
        && cache.fq.get(1).size == 1
        && cache.fq.get(3).size == 1

        && cache.nodes.get(1).next == cache.fq.get(3).sentinel
        && cache.nodes.get(1).prev == cache.fq.get(3).sentinel
        && cache.fq.get(3).sentinel.next == cache.nodes.get(1)
        && cache.fq.get(3).sentinel.prev == cache.nodes.get(1)
        && cache.nodes.get(3).next == cache.fq.get(1).sentinel
        && cache.nodes.get(3).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(3)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(3);
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }

  public static void testLFUCacheTwoHashMapsNMinFqVar2() {
    boolean passed = true;

    LFUCacheTwoHashMapsNMinFqVar cache = new LFUCacheTwoHashMapsNMinFqVar(1);
    passed = passed
        && cache.currSize == 0
        && cache.capacity == 1
        && cache.nodes != null
        && cache.nodes.size() == 0
        && cache.fq != null
        && cache.fq.size() == 0;
    System.out.println(getMethodName() + " - cache creation: " + (passed ? "passed" : "failed"));

    cache.put(1, 1);
    passed = passed
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 1
        && cache.minFQ == 1
        && cache.capacity == 1
        && cache.currSize == 1
        && cache.nodes.size() == 1
        && cache.nodes.get(1).value == 1
        && cache.nodes.get(1).useCounter == 1
        && cache.fq.size() == 1
        && cache.fq.get(1).size == 1
        && cache.nodes.get(1).next == cache.fq.get(1).sentinel
        && cache.nodes.get(1).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(1)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(1);
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));

    cache.put(2,2);
    passed = passed
        && cache.nodes.get(2).value == 2
        && cache.nodes.get(2).useCounter == 1
        && cache.minFQ == 1
        && cache.capacity == 1
        && cache.currSize == 1
        && cache.nodes.size() == 1
        && cache.fq.size() == 1
        && cache.fq.get(1).size == 1
        && cache.nodes.get(2).next == cache.fq.get(1).sentinel
        && cache.nodes.get(2).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(2)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(2);
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));


    int val = cache.get(2);
    passed = passed
        && val == 2
        && cache.nodes.get(2).value == 2
        && cache.nodes.get(2).useCounter == 2
        && cache.minFQ == 2
        && cache.capacity == 1
        && cache.currSize == 1
        && cache.nodes.size() == 1
        && cache.fq.size() == 1
        && cache.fq.get(2).size == 1
        && cache.nodes.get(2).next == cache.fq.get(2).sentinel
        && cache.nodes.get(2).prev == cache.fq.get(2).sentinel
        && cache.fq.get(2).sentinel.next == cache.nodes.get(2)
        && cache.fq.get(2).sentinel.prev == cache.nodes.get(2);
    System.out.println(getMethodName() + " - getting element 2 - should rearrange list: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    passed = passed
        && cache.nodes.get(3).value == 3
        && cache.nodes.get(3).useCounter == 1
        && cache.minFQ == 1
        && cache.capacity == 1
        && cache.currSize == 1
        && cache.nodes.size() == 1
        && cache.fq.size() == 1
        && cache.fq.get(1).size == 1
        && cache.nodes.get(3).next == cache.fq.get(1).sentinel
        && cache.nodes.get(3).prev == cache.fq.get(1).sentinel
        && cache.fq.get(1).sentinel.next == cache.nodes.get(3)
        && cache.fq.get(1).sentinel.prev == cache.nodes.get(3);
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }

  public static void testLFUCacheTwoHashMapsNMinFqVar3() {
    boolean passed = true;
    LFUCacheTwoHashMapsNMinFqVar cache = new LFUCacheTwoHashMapsNMinFqVar(0);
    cache.put(0, 0);
    passed = passed && cache.get(0) == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testLFUCacheThreeHashMaps1() {
    boolean passed = true;

    LFUCacheThreeHashMaps cache = new LFUCacheThreeHashMaps(2);

    cache.put(1, 1);
    passed = passed
        && cache.get(1) == 1;
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));

    cache.put(2,2);
    passed = passed
        && cache.get(2) == 2;
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));

    int val = cache.get(1);
    passed = passed && val == 1;
    System.out.println(getMethodName() + " - getting element 1 - should rearrange list: " + (passed ? "passed" : "failed"));

    val = cache.get(1);
    passed = passed
        && val == 1;
    System.out.println(getMethodName() + " - getting element 1 again - no rearrangments are expected: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    passed = passed
        && cache.get(3) == 3;
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }

  public static void testLFUCacheThreeHashMaps2() {
    boolean passed = true;

    LFUCacheThreeHashMaps cache = new LFUCacheThreeHashMaps(1);

    cache.put(1, 1);
    passed = passed
        && cache.get(1) == 1;
    System.out.println(getMethodName() + " - inserting first element: " + (passed ? "passed" : "failed"));

    cache.put(2,2);
    passed = passed
        && cache.get(2) == 2;
    System.out.println(getMethodName() + " - inserting second element: " + (passed ? "passed" : "failed"));

    int val = cache.get(2);
    passed = passed && val == 2;
    System.out.println(getMethodName() + " - getting element 2 - should rearrange list: " + (passed ? "passed" : "failed"));

    cache.put(3, 3);
    System.out.println(getMethodName() + " - inserting element (3,3): " + (passed ? "passed" : "failed"));
  }


  public static void testLFUCacheThreeHashMaps3() {
    boolean passed = true;
    LFUCacheThreeHashMaps cache = new LFUCacheThreeHashMaps(0);
    cache.put(0, 0);
    passed = passed && cache.get(0) == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testLFUCacheTwoHashMapsNMinFqVar1();
    testLFUCacheTwoHashMapsNMinFqVar2();
    testLFUCacheTwoHashMapsNMinFqVar3();

    testLFUCacheThreeHashMaps1();
    testLFUCacheThreeHashMaps2();
    testLFUCacheThreeHashMaps3();
  }
}
