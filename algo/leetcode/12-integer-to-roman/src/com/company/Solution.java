package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  class Pair {
    int num;
    String roman;
    Pair(int num, String roman) {
      this.num = num;
      this.roman = roman;
    }
  }

  public String intToRoman(int num) {
    Pair[] d = new Pair[]{
        new Pair(1000, "M"),
        new Pair(900, "CM"),
        new Pair(500, "D"),
        new Pair(400, "CD"),
        new Pair(100, "C"),
        new Pair(90, "XC"),
        new Pair(50, "L"),
        new Pair(40, "XL"),
        new Pair(10, "X"),
        new Pair(9, "IX"),
        new Pair(5, "V"),
        new Pair(4, "IV"),
        new Pair(1, "I")
    };

    int idx = 0;
    String output = "";
    while (num != 0) {
      if (num / d[idx].num > 0) {
        output += d[idx].roman;
        num = num - d[idx].num;
      } else {
        idx++;
      }
    }

    return output;
  }
}
