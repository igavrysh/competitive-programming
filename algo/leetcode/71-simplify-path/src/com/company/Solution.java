package com.company;

import java.util.Stack;

public class Solution {
  public String simplifyPath(String path) {
    if (path.charAt(path.length()-1) != '/') {
      path += '/';
    }
    Stack<String> S = new Stack<>();
    char[] pathCh = path.toCharArray();
    int prevS = -1;
    for (int i = 0; i < path.length(); i++) {
      if (pathCh[i] == '/') {
        String name = path.substring(prevS+1, i);
        if (name.length() != 0) {
          if (name.equals("..")) {
            if (S.size() > 0) {
              S.pop();
            }
          } else if (name.equals(".")) {
            // do nothing
          } else {
            S.push(name);
          }
        }
        prevS = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    while (S.size() != 0) {
      sb.insert(0, "/" + S.pop());
    }
    if (sb.length() == 0) {
      sb.append("/");
    }
    return sb.toString();
  }
}
