package com.company;

public class Solution {

  public int maxVowels(String s, int k) {
    boolean[] alpha = new boolean[26];
    char[] input = {'a', 'e', 'i', 'o', 'u'};
    for (int i = 0; i < input.length; i++) {
      alpha[input[i]-'a'] = true;
    }
    if (k > s.length()) {
      return -1;
    }
    int max = 0;
    int currMax = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i < k) {
        if (alpha[s.charAt(i)-'a'] == true) {
          max++;
          currMax++;
        }
        continue;
      }

      if (alpha[s.charAt(i)-'a'] == true) {
        currMax++;
      }
      if (alpha[s.charAt(i-k)-'a'] == true) {
        currMax--;
      }
      if (max < currMax) {
        max = currMax;
      }
    }
    return max;
  }
}
