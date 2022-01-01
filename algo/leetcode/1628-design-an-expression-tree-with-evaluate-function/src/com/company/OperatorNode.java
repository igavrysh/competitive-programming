package com.company;

import java.util.HashMap;
import java.util.function.BiFunction;

public class OperatorNode extends Node {

  Node left;
  Node right;

  public BiFunction<Integer, Integer, Integer> fn;

  public OperatorNode(String op, Node left, Node right) {
    HashMap<String, BiFunction<Integer, Integer, Integer>> biFns = new HashMap<>();
    biFns.put("+", (d1, d2) -> d1 + d2);
    biFns.put("-", (d1, d2) -> d1 - d2);
    biFns.put("*", (d1, d2) -> d1 * d2);
    biFns.put("/", (d1, d2) -> d1 / d2);
    fn = biFns.get(op);
    this.left = left;
    this.right = right;
  }

  public OperatorNode(BiFunction<Integer, Integer, Integer> fn) {
    this.fn = fn;
  }

  @Override
  public int evaluate() {
    if (left == null || right == null) {
      return -1;
    }

    int leftRes = left.evaluate();
    int righRes = right.evaluate();

    return fn.apply(leftRes, righRes);
  }

}
