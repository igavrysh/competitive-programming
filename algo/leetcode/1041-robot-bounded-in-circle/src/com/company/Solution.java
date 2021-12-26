package com.company;

public class Solution {

  public boolean isRobotBounded(String instructions) {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int idx = 0;
    int x = 0, y = 0;

    for (int i = 0; i < instructions.length(); i++) {
      char c = instructions.charAt(i);
      switch (c) {
        case 'G':
          x += dirs[idx][0];
          y += dirs[idx][1];
          break;
        case 'L':
          idx = idx == 0 ? 3 : (idx-1) % 4;
          break;
        case 'R':
          idx = (idx+1) % 4;
      }
    }
    return (x == 0 && y == 0) || idx != 0;
  }
}
