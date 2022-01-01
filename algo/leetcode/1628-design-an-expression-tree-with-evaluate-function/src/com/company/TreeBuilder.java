package com.company;

import java.util.Stack;

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
  Node buildTree(String[] postfix) {
    Stack<Node> nodes = new Stack<>();

    for (int i = 0; i < postfix.length; i++) {
      try {
        Integer t = Integer.parseInt(postfix[i]);
        nodes.push(new NumericNode(t));
      } catch (NumberFormatException ex) {
        if (nodes.size() >= 2) {
          Node right = nodes.pop();
          Node left = nodes.pop();
          OperatorNode node = new OperatorNode(postfix[i], left, right);
          nodes.push(node);
        }
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