package com.company;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {

  HashMap<String, BiFunction<Integer, Integer, Integer>> biFns;

  public TreeBuilder() {
    biFns = new HashMap<>();
    biFns.put("+", (d1, d2) -> d1 + d2);
    biFns.put("-", (d1, d2) -> d1 - d2);
    biFns.put("*", (d1, d2) -> d1 * d2);
    biFns.put("/", (d1, d2) -> d1 / d2);
  }

  BiFunction<Integer, Integer, Integer> fn(String operator) {
    return biFns.get(operator);
  }

  Node buildTree(String[] postfix) {
    Stack<Node> nodes = new Stack<>();
    for (int i = 0; i < postfix.length; i++) {
      BiFunction<Integer, Integer, Integer> fn = fn(postfix[i]);
      if (fn != null && (nodes.size() >= 2)) {
        Node right = nodes.pop();
        Node left = nodes.pop();
        OperatorNode node = new OperatorNode(fn(postfix[i]), left, right);
        nodes.push(node);
      } else {
        Integer t = Integer.parseInt(postfix[i]);
        nodes.push(new NumericNode(t));
      }
    }
    return nodes.pop();
  }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */