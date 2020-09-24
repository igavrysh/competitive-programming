package com.company;

public class SolutionRecursive {
  public int numDecodings(String s) {
    int[] cache = new int[s.length()];
    for (int i = 0; i < cache.length; i++) {
      cache[i] = -1;
    }
    return num(s.toCharArray(), 0, cache);
  }

  private int num(char[] s, int index, int[] cache) {
    if (index >= s.length) {
      return 1;
    }

    int l1 = 0;
    int l2 = 0;

    int curr = s[index] - '0';

    if (curr != 0) {
      if (index+1 < cache.length && cache[index+1] != -1) {
        l1 = cache[index+1];
      } else {
        l1 = num(s, index + 1, cache);
      }

      if (index+1 < s.length) {
        int next = s[index+1] - '0';
        if ((curr * 10 + next) <= 26) {
          if (index+2 < cache.length && cache[index+2] != -1) {
            l2 = cache[index+2];
          } else {
            l2 = num(s, index + 2, cache);
          }

        }
      }
    }

    cache[index] = l1 + l2;

    return cache[index];
  }
}
