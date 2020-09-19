package com.company;

class Solution {
  enum DPValues {
    NOT_SET, MATCHED, MISMATCHED;
  }

  public boolean isMatch(String s, String p) {
    return isM(0, 0, s, p);
  }

  private boolean isM(int iS, int iP, String s, String p) {
    if (iS >= s.length() && iP >= p.length()) {
      return true;
    }

    if (iP < p.length() && p.charAt(iP) == '*') {
      boolean l1 = false;
      if (iS < s.length() && iP < p.length()) {
        l1 = isM(iS+1, iP+1, s, p);
      }
      boolean l2 = false;
      if (iS < s.length()) {
        l2 = isM(iS+ 1, iP, s, p);
      }
      boolean l3 = false;
      if (iP < p.length()) {
        l3 = isM(iS, iP+1, s, p);
      }

      return l1 || l2 || l3;
    }

    if ((iS == s.length() && iP != p.length())
      || (iS != s.length() && iP == p.length())
    ) {
      return false;
    }

    if (p.charAt(iP) == '?') {
      return isM(iS+1, iP+1, s, p);
    }

    if (p.charAt(iP) == s.charAt(iS)) {
      return isM(iS+1, iP+1, s, p);
    }
    return false;
  }
}