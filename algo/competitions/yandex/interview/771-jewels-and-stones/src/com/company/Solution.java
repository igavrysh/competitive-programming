package com.company;

public class Solution {
  public int numJewelsInStones(String J, String S) {
    int[] freq = new int[122];
    for (char c : S.toCharArray()) {
      freq[c-'A'] = freq[c-'A']+1;
    }
    int result = 0;
    for (char c : J.toCharArray()) {
      result += freq[c-'A'];
    }
    return result;
  }
}
