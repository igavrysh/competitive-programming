package com.company;

class Solution {
  enum MT {
    NOT_SET, MATCHED, MISMATCHED;
  }

  public boolean isMatch(String s, String p) {
    MT[][] cache = new MT[s.length() + 1][p.length() + 1];
    for (int i = 0; i < cache.length; i++) {
      for (int j = 0; j < cache[i].length; j++) {
        cache[i][j] = MT.NOT_SET;
      }
    }

    return isM(0, 0, s, p, cache);
  }

  private boolean isM(int iS, int iP, String s, String p, MT[][] cache) {
    if (cache[iS][iP] != MT.NOT_SET) {
      return cache[iS][iP] == MT.MATCHED ? true : false;
    }

    if (iS >= s.length() && iP >= p.length()) {
      cache[iS][iP] = MT.MATCHED;
      return true;
    }

    if (iP < p.length() && p.charAt(iP) == '*') {
      boolean l1 = false;
      if (iS < s.length() && iP < p.length()) {
        l1 = isM(iS+1, iP+1, s, p, cache);
      }
      boolean l2 = false;
      if (iS < s.length()) {
        l2 = isM(iS+1, iP, s, p, cache);
      }
      boolean l3 = false;
      if (iP < p.length()) {
        l3 = isM(iS, iP+1, s, p, cache);
      }

      cache[iS][iP] = l1 || l2 || l3 ? MT.MATCHED : MT.MISMATCHED;
      return l1 || l2 || l3;
    }

    if ((iS == s.length() && iP != p.length())
      || (iS != s.length() && iP == p.length())
    ) {
      cache[iS][iP] = MT.MISMATCHED;
      return false;
    }

    if (p.charAt(iP) == '?') {
      boolean res = isM(iS+1, iP+1, s, p, cache);
      cache[iS][iP] = res ? MT.MATCHED : MT.MISMATCHED;
      return res;
    }

    if (p.charAt(iP) == s.charAt(iS)) {
      boolean res = isM(iS+1, iP+1, s, p, cache);
      cache[iS][iP] = res ? MT.MATCHED : MT.MISMATCHED;
      return res;
    }

    cache[iS][iP] = MT.MISMATCHED;
    return false;
  }
}