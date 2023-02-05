package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        return BT(n,"", 0, 0);
    }

    private List<String> BT(int n, String exp, int leftBrackets, int rightBrackets) {
        if (leftBrackets == n
            && leftBrackets == rightBrackets) {
            return Arrays.asList(exp);
        }

        List<String> lResult = new ArrayList<>();
        List<String> rResult = new ArrayList<>();

        if (leftBrackets >= rightBrackets) {
            if (leftBrackets < n) {
                lResult = BT(n, exp + "(", leftBrackets + 1, rightBrackets);
            }

            if (rightBrackets < n) {
                rResult = BT(n, exp + ")", leftBrackets, rightBrackets + 1);
            }

            lResult.addAll(rResult);
        }
        return lResult;
    }
}
