package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<String> generateParenthesis(int n) {
    return generateParenthesisInternal(
        n,
        "",
        0,
        0);
  }

  private List<String> generateParenthesisInternal(
      int n,
      String expression,
      int leftBrackets,
      int rightBrackets) {

    if (leftBrackets == n
        && leftBrackets == rightBrackets) {
      return Arrays.asList(expression);
    }

    List<String> lResult = new ArrayList<>();
    List<String> rResult = new ArrayList<>();

    if (leftBrackets >= rightBrackets) {
      if (leftBrackets < n) {
        lResult = generateParenthesisInternal(
            n,
            expression + "(",
            leftBrackets + 1,
            rightBrackets);

      }

      if (rightBrackets < n) {
        rResult = generateParenthesisInternal(
            n,
            expression + ")",
            leftBrackets,
            rightBrackets + 1
        );
      }

      lResult.addAll(rResult);
    }
    return lResult;
  }
}
