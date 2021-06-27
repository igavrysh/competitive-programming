package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

  public int maxUniqueSplit(String s) {
    List<Integer> result = new ArrayList<>();
    result.add(1);
    BT(0, "", new HashSet<>(), result, s);
    return result.get(0);
  }

  private void BT(int start, String acc, HashSet<String> I, List<Integer> max, String s) {
    if (start >= s.length()) {
      if (acc.length() > 0) {
        if (I.contains(acc)) {
          return;
        } else {
          I.add(acc);
        }
      }
      if (max.get(0) < I.size()) {
        max.set(0, I.size());
      }
      I.remove(acc);
      return;
    }
    char curr = s.charAt(start);
    if (acc.length() > 0 && !I.contains(acc)) {
      I.add(acc);
      BT(start+1, curr+"", I, max, s);
      I.remove(acc);
    }
    BT(start+1, acc + curr, I, max, s);
  }

}
