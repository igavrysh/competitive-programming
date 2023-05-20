package com.company;

public class SolutionDP2Practice2 {
    public int numDecodings(String s) {
        int n = s.length();
        int prevDP = 0, prevPrevDP = 0;
        int numI = 0, prevNumI = 0;
        for (int i = 0; i < n; i++) {
            numI = s.charAt(i) - '0';
            int currDP = 0;
            if (numI >= 1 && numI <= 9 && (i == 0 || prevDP > 0)) {
                currDP += (i == 0 ? 1 : prevDP);
            }
            if (i >= 1) {
                int twoDigit = prevNumI*10+numI;
                if (twoDigit >= 10 && twoDigit <= 26 && (i == 1 || prevPrevDP > 0)) {
                    currDP += (i==1 ? 1 : prevPrevDP);
                } 
            }
            prevPrevDP = prevDP;
            prevDP = currDP;
            prevNumI = numI;
            if (i > 1 && prevDP == 0 && prevPrevDP == 0) {
                break;
            }
        }
        return n > 0 ? prevDP : 1;
    }
}
