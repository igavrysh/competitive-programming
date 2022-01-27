package com.company;

import java.util.HashSet;

public class Solution {
  public boolean isScramble(String s1, String s2) {
    return true;
  }

  private boolean bt(int s, int e, String str, String res, HashSet<String> dict) {
    for (int i = s+1; i < e; i++) {
      String splitP1 = str.substring(s, i);
      String splitP2 = str.substring(i, e+1);
      
      String strV1 = new String(str);
      String strV2 = splitP2 + splitP1;
    


    }
    return false;
  }
}