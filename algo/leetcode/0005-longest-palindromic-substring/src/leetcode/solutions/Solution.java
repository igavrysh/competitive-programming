package leetcode.solutions;

public class Solution {
  public String longestPalindrome(String str) {
    int s = 0, e = 0;
    for (int i = 0; i < str.length(); i++) {
      int l = Math.max(expand(i, i+1, str), expand(i, i, str));
      s = i-(l-1)/2;
      e = i+l/2;
    }
    return str.substring(s, e+1);
  }

  private int expand(int s, int e, String str) {
    int l = 0;
    while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
      s--;
      e++;
      l += s == e ? 1 : 2;
    }
    return l;
  }
}
