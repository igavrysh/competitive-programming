import java.util.ArrayList;

public class SolutionNSq {
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

        int rPnt = N-1;
        int lPnt = 0;
        int addedSymbols = 0;

        while (!equal(chrs, lHashS + addedSymbols, lHashE, rHashS-addedSymbols, rHashE)) {
            if (chrs.size() % 2 == 0) {
                Character chrToAddToL = chrs.get(rPnt);
                chrs.add(lPnt, chrToAddToL);
                addedSymbols++;
                partSize++;
            } else {
                Character chrToAddToL = chrs.get(rPnt);
                chrs.add(lPnt, chrToAddToL);
                addedSymbols++;
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
        test9();
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
        String expOutput = "ababbabbbababbbabbaba";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        String s = "abc";
        String expOutput = "cbabc";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        String s = "bbc";
        String expOutput = "cbbc";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String s = "ab";
        String expOutput = "bab";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String s = "abcdef";
        String expOutput = "fedcbabcdef";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s = "abcd";
        String expOutput = "dcbabcd";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "a";
        String expOutput = "a";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "";
        String expOutput = "";
        SolutionNSq sol = new SolutionNSq();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
