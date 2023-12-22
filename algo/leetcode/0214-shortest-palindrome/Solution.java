import java.util.ArrayList;

class Solution {
    
    private int insertIntoLeftHash(char chr, int insertPosFromLeft, int inputHash) {
        int splitter = (int)Math.pow(27, insertPosFromLeft);
        int lside = inputHash % splitter;
        int rside = inputHash / splitter;
        return lside + h(chr) * splitter + rside * splitter * 27;
    }

    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int N = s.length();
        ArrayList<Character> chrs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            chrs.add(s.charAt(i));
        }

        int partSize = N/2 + N%2;
        int lHashS = 0;
        int lHashE = lHashS + partSize-1;
        int rHashS = N-1;
        int rHashE = rHashS - (partSize-1);

        int lHash = hashCode(chrs, lHashS, lHashE);
        int rHash = hashCode(chrs, rHashS, rHashE);

        int rPnt = N-1;
        int lPnt = 0;

        int mult = (int)Math.pow(27, rHashS-rHashE);

        while (lHash != rHash || !equal(chrs, lHashS, lHashE, rHashS, rHashE)) {
            if (chrs.size() % 2 == 0) {
                mult *= 27;
                Character chrToAddToR = chrs.get(rHashE-1);
                rHash += h(chrToAddToR) * mult;
                Character chrToAddToL = chrs.get(rPnt);
                chrs.add(lPnt, chrToAddToL);
                lHash = insertIntoLeftHash(chrToAddToL, lPnt, lHash);
                partSize++;
            } else {
                lHash = lHash % mult;
                Character chrToAddToL = chrs.get(rPnt);
                chrs.add(lPnt, chrToAddToL);
                lHash = insertIntoLeftHash(chrToAddToL, lPnt, lHash);
            }

            lPnt++;
            lHashE = lHashS + (partSize-1);
            rHashS = chrs.size()-1;
            rHashE = rHashS - (partSize-1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chrs.size(); i++) {
            sb.append(chrs.get(i));
        }

        return sb.toString();
    }

    private int h(Character chr) {
        return (chr - 'a') + 1;
    }

    private int hashCode(ArrayList<Character> chrs, int s, int e) {
        int incr = 0;
        if (e >= s) {
            incr = 1;
        } else if (e < s) {
            incr = -1;
        }
        incr *= -1;
        int h = 0;
        for (int i = e; i != s+incr; i += incr) {
            h = h * 27 + h(chrs.get(i));
        }
        return h;
    }

    private boolean equal(ArrayList<Character> list, int lS, int lE, int rS, int rE) {
        int incr = rS <= rE ? 1 : -1;
        int j = lS;
        for (int i = rS; i != rE+incr; i += incr) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            j += incr * (-1);
        }
        return true;
    }

    public static void main(String[] args) {
        test8();
        test7();
        test4();
        test6();
        test5();
        test1();
        test2();
        test3();
    }

    public static void test9() {
        String s = "ababbbabbaba";
        String expOutput = "ababbabbb aba|bbbabbaba";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        String s = "abc";
        String expOutput = "cbabc";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        String s = "bbc";
        String expOutput = "cbbc";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String s = "ab";
        String expOutput = "bab";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String s = "abcdef";
        String expOutput = "fedcbabcdef";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s = "abcd";
        String expOutput = "dcbabcd";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "a";
        String expOutput = "a";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "";
        String expOutput = "";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
