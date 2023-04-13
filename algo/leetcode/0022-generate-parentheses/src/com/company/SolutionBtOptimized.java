package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionBTOptimized {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        BT(0, 0, n, new char[2*n], output);
        return output;
    }

    private void BT(int l, int r, int n, char[] acc, List<String> output) {
        if (l+r == 2 * n && l == r) {
            output.add(new String(acc));
            return;
        }

        if (l < n && l>=r) {
            acc[l+r] = '(';
            BT(l+1, r, n, acc, output);
        }

        if (l>r) {
            acc[l+r] = ')';
            BT(l, r+1, n, acc, output);
        }
    }
}
