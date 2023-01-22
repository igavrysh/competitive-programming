package com.company;

public class SolutionRecursive {
    public int numDistinct(String s, String t) {
        return num(0, 0, s, t);
    }

    private int num(int iS, int iT, String s, String t) {
        if (iT == t.length()) {
            return 1;
        }

        if (iS == s.length()) {
            return 0;
        }

        int result = 0;
        if (t.charAt(iT) == s.charAt(iS)) {
            result += num(iS+1, iT+1, s, t);
        }
        result += num(iS+1, iT, s, t);

        return result;
    }
}
