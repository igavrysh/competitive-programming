package com.company;

import java.util.Stack;

public class Solution {

  // infix expression → postfix expression → binary tree root node
  public Node expTree(String infixExp) {
    return binaryTree(postfixExp(infixExp));
  }

  // binaryTree returns a root node of tree built based on postfix expression
  private Node binaryTree(String postfix) {
    Stack<Node> stack = new Stack<>();
    char[] S = postfix.toCharArray();
    for (char c : S) {
      // if the number, create a Node, put number as val into node, push node to stack
      if (c-'0'>=0 && c-'0'<=9) {
        stack.push(new Node(c));
        continue;
      }
      // if the operator, pop two last operands from stack, create node with operation and two
      // operand as right and left children, push new node to the stack
      if ((c=='*' || c=='/' || c=='+' || c=='-') && stack.size() >= 2) {
        Node right = stack.pop();
        Node left = stack.pop();
        stack.push(new Node(c, left, right));
      }
    }
    // as a result, stack should include just one node that is a root node for given expression
    return stack.pop();
  }

  // postfixExp outputs postfix expression based on infixExp input
  private String postfixExp(String infixExp) {
    char[] S = infixExp.toCharArray();
    Stack<Character> operations = new Stack<>();
    // sb is used for efficient string manipulations
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length; i++) {
      // if operand, just append postfix expression with it
      if (S[i]-'0' >= 0 && S[i]-'0' <= 9) {
        sb.append(S[i]);
        continue;
      }
      // previously opened bracket (aka "(" ) has closed, finalize conversion for all operators that
      // are between those two brackets. Operands are already included in postfix expression by lines above
      if (S[i] == ')') {
        while (!operations.isEmpty() && operations.peek() != '(') {
          sb.append(operations.pop());
        }
        // clean operations stack - remove open bracket before proceeding
        if (operations.peek() == '(') {
          operations.pop();
        }
        continue;
      }

      // brackets have the highest order, immediately push to stack
      if (S[i] == '(') {
        operations.push('(');
        continue;
      }

      // convert all operators with higher order that are currently on stack before pushing
      // operator with lower order, aka operators with higher order should be evaluated first
      while (!operations.isEmpty() && order(operations.peek()) >= order(S[i])) {
        sb.append(operations.pop());
      }

      // push operator with lower order to stack
      operations.push(S[i]);
    }

    // if any operators left on stack, pop them and finalize expression
    while (!operations.isEmpty()) {
      sb.append(operations.pop());
    }

    return sb.toString();
  }

  // get order of operations, the higher value, the greater order
  private int order(char c) {
    switch (c) {
      case '/':
      case '*':
        return 2;
      case '+':
      case '-':
        return 1;
      default:
        return -1;
    }
  }
}