package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

  public static void testSerializationDeserialization1() {
    Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3),
        n4 = new Node(4), n5 = new Node(5), n6 = new Node(6);
    n1.children = Arrays.asList(new Node[]{n2,n3,n4});
    n2.children = Arrays.asList(new Node[]{n5,n6});
    Codec c = new Codec();
    String output = c.serialize(n1);
    boolean passed = output.contentEquals("1,null,2,3,4,null,5,6,null,null,null,null,null");

    Node root = c.deserialize(output);
    passed = passed && root.val == n1.val;
    passed = passed
        && root.children.size() == 3
        && root.children
        .stream()
        .map((Node n) -> { return n.val; } )
        .collect(Collectors.toList())
        .containsAll(Arrays.asList(new Integer[]{2,3,4}));
    passed = passed
        && root.children.get(0).children.size() == 2
        && root.children.get(0).children
        .stream()
        .map((Node n) -> { return n.val; } )
        .collect(Collectors.toList())
        .containsAll(Arrays.asList(new Integer[]{5,6}));
    System.out.println("testSerializationDeserialization1: " + (passed ? "passed" : "failed"));
  }

  public static void testSerializationDeserialization2() {
    Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3),
        n4 = new Node(4), n5 = new Node(5), n6 = new Node(6),
        n7 = new Node(7), n8 = new Node(8), n9 = new Node(9),
        n10 = new Node(10), n11 = new Node(11), n12 = new Node(12),
        n13 = new Node(13), n14 = new Node(14);
    n1.children = Arrays.asList(new Node[]{n2,n3,n4,n5});
    n3.children = Arrays.asList(new Node[]{n6,n7});
    n4.children = Arrays.asList(new Node[]{n8});
    n5.children = Arrays.asList(new Node[]{n9,n10});
    n7.children = Arrays.asList(new Node[]{n11});
    n8.children = Arrays.asList(new Node[]{n12});
    n9.children = Arrays.asList(new Node[]{n13});
    n11.children = Arrays.asList(new Node[]{n14});
    Codec c = new Codec();
    String output = c.serialize(n1);
    boolean passed = output.contentEquals("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14,null,null,null,null");
    System.out.println("testSerialization2: " + (passed ? "passed" : "failed"));
  }

  public static void testSerializationDeserialization3() {
    Node n1 = null;
    Codec c = new Codec();
    String output = c.serialize(n1);
    boolean passed = output.contentEquals("null");

    Node root = c.deserialize(output);
    passed = passed && root == null;
    System.out.println("testSerializationDeserialization3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testSerializationDeserialization1();
    testSerializationDeserialization2();
    testSerializationDeserialization3();
  }
}
