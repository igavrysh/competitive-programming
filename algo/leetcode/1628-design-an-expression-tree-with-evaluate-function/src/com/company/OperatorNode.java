package com.company;

import java.util.function.BiFunction;

public class OperatorNode extends Node {
  Node left;
  Node right;

  public BiFunction<Integer, Integer, Integer> fn;

  public OperatorNode(BiFunction<Integer, Integer, Integer> fn, Node left, Node right) {
    this.fn = fn;
    this.left = left;
    this.right = right;
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
