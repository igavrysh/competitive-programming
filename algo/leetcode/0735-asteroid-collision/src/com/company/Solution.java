package com.company;

import java.util.Stack;

public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack <Integer> stack = new Stack<>();
    for (int i = 0; i < asteroids.length; i++) {
      if (asteroids[i] < 0) {
        int currA = Math.abs(asteroids[i]);
        while (!stack.isEmpty() && stack.peek() > 0 && currA != 0) {
          if (stack.peek() == currA) {
            currA = 0;
            stack.pop();
          } else if (stack.peek() < currA) {
            stack.pop();
          } else if (stack.peek() > currA) {
            currA = 0;
          }
        }
        if (currA != 0) {
          stack.push(-currA);
        }
      } else {
        stack.push(asteroids[i]);
      }
    }
    int N = stack.size();
    int i = 1;
    int[] result = new int[N];
    while (!stack.isEmpty()) {
      result[N-i++] = stack.pop();
    }
    return result;
  }
}
