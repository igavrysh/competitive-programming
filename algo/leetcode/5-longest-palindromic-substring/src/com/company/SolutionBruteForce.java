package com.company;

public class SolutionBruteForce {
  public String longestPalindrome(String s) {
    int N = s.length();
    String[] output = new String[1];
    output[0] = "";
    longestPalindromeInternal(s, 0, output);
    return output[0];
  }

  private void longestPalindromeInternal(
      String s,
      int start,
      String[] output
  ) {
    for (int i = start; i < s.length(); i++) {
      if (isPalendrome(s, start, i)
          && output[0].length() < (i + 1 - start)
      ) {
        output[0] = s.substring(start, i + 1);
      }
      longestPalindromeInternal(s, i + 1, output);
    }
  }

  private boolean isPalendrome(String s, int start, int end) {
    for (int i = 0; i < (end + 1 - start) / 2; i++) {
      if (s.charAt(start + i) != s.charAt(end - i)) {
        return false;
      }
    }
    return true;
  }
}
