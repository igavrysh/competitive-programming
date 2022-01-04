package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void test1() {
    Node root = new Node(
        1,
        List.of(
            new Node(
                3,
                List.of(
                    new Node(5),
                    new Node(6)
                )
            ),
            new Node(2),
            new Node(4)
        )
    );
    Solution s = new Solution();
    int output = s.maxDepth(root);
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Node root = new Node(
        1,
        List.of(
            new Node(2),
            new Node(
                3,
                List.of(
                    new Node(6),
                    new Node(
                        7,
                        List.of(
                            new Node(
                                11,
                                List.of(
                                    new Node(14)
                                )
                            )
                        )
                    )
                )),
            new Node(
                4,
                List.of(
                    new Node(
                        8,
                        List.of(new Node(12))
                    )
                )),
            new Node(
                5,
                List.of(
                    new Node(
                        9,
                        List.of(
                            new Node(13))
                    ),
                    new Node(10)
                ))
        )
    );
    Solution s = new Solution();
    int output = s.maxDepth(root);
    boolean passed = output == 5;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
