package leetcode.solutions;

public class Solution {
  public String longestPalindrome(String str) {
    int s = 0, e = 0;

    for (int i = 0; i < str.length(); i++) {
      int l = expand(i, i + 1, str);
      if (l*2 > e-s) {
        s=i+1-l;
        e=i+l;
      }
      l = expand(i, i, str);
      if (l*2-1 > e-s) {
        s=i+1-l;
        e=i-1+l;
      }
    }
    return str.substring(s, e+1);
  }

  private int expand(int s, int e, String str) {
    int l = 0;
    while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
      s--;
      e++;
      l++;
    }
    return l;
  }
}
