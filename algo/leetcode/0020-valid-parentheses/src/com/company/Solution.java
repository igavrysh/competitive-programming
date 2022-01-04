package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public boolean isValid(String s) {
    char[] chs = s.toCharArray();
    List<Character> stack = new ArrayList<>();
    for (char c : chs) {
      if (c == '{' || c == '(' || c == '[') {
        stack.add(c);
      } else if (c == '}' || c == ')' || c == ']') {
        if (stack.size() == 0) {
          return false;
        }
        char lastOnStack = stack.get(stack.size() - 1);
        if ((lastOnStack == '{' && c == '}')
            || (lastOnStack == '[' && c == ']')
            || (lastOnStack == '(' && c == ')')
        ) {
          stack.remove(stack.size() - 1);
        } else {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }
}
