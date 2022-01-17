package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiFunction;

public class Solution {

  private class PostfixRecord {
    String value;
    public PostfixRecord(String value) {
      this.value = value;
    }
  }

  private class PostfixOperandRecord extends PostfixRecord {
    Integer intValue;

    public PostfixOperandRecord(String value) {
      super(value);
      intValue = Integer.valueOf(value);
    }

    public PostfixOperandRecord(int intValue) {
      super(Integer.toString(intValue));
      this.intValue = intValue;
    }

  }

  private class PostfixOperationRecord extends PostfixRecord {
    public PostfixOperationRecord(String value) {
      super(value);
    }
  }

  public int calculate(String s) {
    List<PostfixRecord> postfix = infixToPostfix(s);
    return evalPostfix(postfix);
  }

  private List<PostfixRecord> infixToPostfix(String infix) {
    List<PostfixRecord> L = new ArrayList<>();
    StringBuilder operandSB = new StringBuilder();
    Stack<Character> operationsS = new Stack<>();
    char[] S = infix.toCharArray();
    for (int i = 0; i < S.length; i++) {
      String operand = "";
      char c = S[i];
      if (c-'0'>=0 && c-'9'<=0) {
        operandSB.append(c);
        if (i == S.length-1) {
          operand = operandSB.toString();
          operandSB.setLength(0);
          L.add(new PostfixOperandRecord(operand));
        }
        continue;
      }

      if (c=='*' || c=='/' || c=='+' || c=='-' || c==')') {
        operand = operandSB.toString();
        operandSB.setLength(0);
        if (operand.length() > 0) {
          L.add(new PostfixOperandRecord(operand));
        }
      }

      if (c=='(') {
        operationsS.push(c);
        continue;
      }

      if (c==')') {
        while (operationsS.peek()!='(') {
          L.add(new PostfixOperationRecord(Character.toString(operationsS.pop())));
        }
        operationsS.pop();
        continue;
      }

      if (!(c=='*' || c=='/' || c=='+' || c=='-')) {
        continue;
      }

      while (!operationsS.isEmpty() && priority(operationsS.peek()) >= priority(c)) {
        L.add(new PostfixOperationRecord(Character.toString(operationsS.pop())));
      }
      operationsS.push(c);
    }

    while (!operationsS.isEmpty()) {
      L.add(new PostfixOperationRecord(Character.toString(operationsS.pop())));
    }

    return L;
  }

  private int priority(char operation) {
    switch (operation) {
      case '*':
      case '/':
        return 2;
      case '+':
      case '-':
        return 1;
      default:
        return -1;
    }
  }

  private BiFunction<Integer, Integer, Integer> fn(char operation) {
    switch (operation) {
      case '*': return (Integer i1, Integer i2) -> { return i1 * i2; };
      case '/': return (Integer i1, Integer i2) -> { return i1 / i2; };
      case '+': return (Integer i1, Integer i2) -> { return i1 + i2; };
      case '-': return (Integer i1, Integer i2) -> { return i1 - i2; };
      default: return (Integer i1, Integer i2) -> { return -1; };
    }
  }

  private int evalPostfix(List<PostfixRecord> postfix) {
    Stack<PostfixOperandRecord> operandsS = new Stack<>();
    int result = 0;
    for (int i = 0; i < postfix.size(); i++) {

      if (postfix.get(i) instanceof PostfixOperationRecord) {
        if (operandsS.size() >= 2) {
          PostfixOperandRecord o2 = operandsS.pop();
          PostfixOperandRecord o1 = operandsS.pop();
          Integer res = fn(postfix.get(i).value.charAt(0)).apply(o1.intValue, o2.intValue);
          PostfixOperandRecord resOperand = new PostfixOperandRecord(res);
          operandsS.push(resOperand);
        }
      }

      if (postfix.get(i) instanceof PostfixOperandRecord) {
        operandsS.push((PostfixOperandRecord)postfix.get(i));
      }
    }
    return operandsS.pop().intValue;
  }
}
