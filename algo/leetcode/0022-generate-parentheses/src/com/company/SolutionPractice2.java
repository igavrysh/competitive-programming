package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2 {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        char[] acc = new char[2*n];
        BT(0, 0, n, acc, output);
        return output;
    }

    private void BT(int l, int r, int n, char[] acc, List<String> output) {
        if (r > l) {
            return;
        }

        if (r==l && l == n) {
            output.add(new String(acc));
        }

        if (l+r+1-1 >= 2*n) {
            return;
        }

        acc[l+1+r-1]='(';
        BT(l+1, r, n, acc, output);
        acc[l+r+1-1]=')';
        BT(l, r+1, n, acc, output);
    }
}
