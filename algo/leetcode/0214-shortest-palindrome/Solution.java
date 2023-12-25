import java.util.ArrayList;

class Solution {

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

        long lHash = hashCode(chrs, lHashS, lHashE);
        long  rHash = hashCode(chrs, rHashS, rHashE);

        int rPnt = N-1;
        int lPnt = 0;

        // ... lHashS ... lHashEnd < or <= rHashE ... rHashS ...
        while ((lHash != rHash || !equal(chrs, lHashS, lHashE, rHashS, rHashE)) && lHashS <= lHashE) {
            if (chrs.size() % 2 == 0) {
                Character chrToAddToR = chrs.get(lHashE);
                Character chrToAddToL = chrs.get(rPnt);
                chrs.add(lPnt, chrToAddToL);

                lHashS += 1;
                lHashE += 1;

                int h_chrToAddToL = h(chrToAddToL);
                rHash = rHash - h(chrToAddToL);
                rHash = rHash / 27;

                long tmp = hashCode(chrs, rHashS, rHashE+1);

                rHash = (rHash + h(chrToAddToR) * (long)powerWithMod(27, rHashS-rHashE, mod)) % mod;
            } else {
                Character chrToAddToL = chrs.get(rPnt);
                Character chrToRemoveFromL = chrs.get(lHashE);

                chrs.add(lPnt, chrToAddToL);

                lHash = (lHash - powerWithMod(27, lHashE - lHashS, mod) * h(chrToRemoveFromL)) % mod;

                lHashS += 1;

                rHash = rHash - h(chrToAddToL);
                rHash = rHash / 27;
                rHashE += 1;
            }
            lPnt++;

            String lHashStr = "";
            for (int i = lHashS; i <= lHashE; i++) {
                lHashStr += chrs.get(i);
            }

            String rHashStr = "";
            for (int i = rHashE; i <= rHashS; i++) {
                rHashStr += chrs.get(i);
            }
            long lHashProxy = hashCode(chrs, lHashS, lHashE);
            long rHashProxy = hashCode(chrs, rHashS, rHashE);
            int t = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chrs.size(); i++) {
            sb.append(chrs.get(i));
        }

        return sb.toString();
    }

    static long powerWithMod(long base, long exponent, long modulus) {
        // result is initially 1, as any number raised to the power of 0 is 1
        long result = 1;

        // Update base if it is more than or equal to modulus
        base = base % modulus;

        while (exponent > 0) {
            // If exponent is odd, multiply base with result
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }

            // exponent must be even now
            exponent = exponent >> 1; // exponent divided by 2
            base = (base * base) % modulus;
        }

        return result;
    }

    private int h(Character chr) {
        return ((chr - 'a') + 1);
    }

    private long mod = (long)Math.pow(10, 9) + 7;

    private long hashCode(ArrayList<Character> chrs, int s, int e) {
        int incr = 0;
        if (e >= s) {
            incr = 1;
        } else if (e < s) {
            incr = -1;
        }
        incr *= -1;
        long h = 0;
        for (int i = e; i != s+incr; i += incr) {
            char c = chrs.get(i);
            int chr_hash = h(chrs.get(i));
            h = (h * 27 + chr_hash) % mod;
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
        int t = Integer.MAX_VALUE - 10;
        t = t * 27;
        t = t/27;


        test_big_sample();
        test6_2();
        test6();
        test4();
        test9();
        test8();
        test7();
        test5();
        test1();
        test2();
        test3();
    }

    public static void test_big_sample() {
        String s = "abcdefghijklmnopqrstuvwzxy";
        String expOutput = "zyxwvutsrqponmlkjihgfedcbabcdefghijklmnopqrstuvwzxy";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        String s = "ababbbabbaba";
        String expOutput = "ababbabbbababbbabbaba";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test9: " + (passed ? "passed" : "failed"));
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
        String s = "abcde";
        String expOutput = "edcbabcde";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test6_2() {
        String s = "abcdef";
        String expOutput = "fedcbabcdef";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6_2: " + (passed ? "passed" : "failed"));
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
