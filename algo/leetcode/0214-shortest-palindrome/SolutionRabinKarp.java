class SolutionRabinKarp {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chrs = s.toCharArray();
        int N = chrs.length;
        int maxPolLen = 1;
        int leftS = 0;
        int leftE = 0;
        int rightS = 1;
        int rightE = 1;

        int hashL = h(chrs[leftS]);
        int hashR = h(chrs[rightS]);

        int power = 1;

        for (rightE = 1; rightE < N; rightE++) {
            if (hashL == hashR /*&& equal(chrs, leftS, leftE, rightS, rightE)*/ ) {
                maxPolLen = (rightE - leftS + 1);
            }

            if (rightE == N-1) {
                continue;
            }

            if (rightE % 2 == 1) {
                power = (power * 27) % mod;
                hashR = (hashR * 27 + h(chrs[rightE+1])) % mod;
                hashL = (hashL + h(chrs[rightS]) * power)%mod;
                leftE++;
            } else {
                hashR = (hashR - h(chrs[rightS]) * power) % mod;
                if (hashR < 0) {
                    hashR += mod;
                }
                hashR = (27 * hashR + h(chrs[rightE+1]))%mod;
                rightS++;
            }
            
            //int proxyHashL = hashCode(chrs, leftS, leftE);
            //int proxyHashR = hashCodeRev(chrs, rightS, rightE+1);
            //int t = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxPolLen; i++) {
            sb.append(chrs[i]);
        }

        for (int i = maxPolLen; i < N; i++) {
            sb.insert(0, chrs[i]);
            sb.insert(sb.length(), chrs[i]);
        }

        return sb.toString();
    }

    private static int mod = 1299709; //(int)Math.pow(10, 4);

    private int h(Character chr) {
        return ((chr - 'a') + 1);
    }

    private boolean equal(char[] chrs, int leftS, int leftE, int rightS, int rightE) {
        for (int i=leftS, j=rightE; i <= leftE; i++, j--) {
            if (chrs[i] != chrs[j]) {
                return false;
            }
        }
        return true;
    }

    private int hashCode(char[] chrs, int s, int e) {
        int h = 0;
        for (int i = e; i >= s; i--) {
            char chr = chrs[i];
            int chr_hash = h(chr);
            h = (h * 27 + chr_hash) % mod;
        }
        return h;
    }

    private int hashCodeRev(char[] chrs, int s, int e) {
        int h = 0;
        for (int i = s; i <= e; i++) {
            char chr = chrs[i];
            int chr_hash = h(chr);
            h = (h * 27 + chr_hash) % mod;
        }
        return h % mod;
    }

    public static void main(String[] args) {
        test1();
        test0();
        test2();
        test3();
        test4();
        test5();
        test6();
        test6_2();
        test7();
        test8();
        test9();
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test0() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String expOutput = "zyxwvutsrqponmlkjihgfedcbabcdefghijklmnopqrstuvwxyz";
        //String s = "abcd";
        //String expOutput = "dcbabcd";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test0: " + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        String s = "ababbbabbaba";
        String expOutput = "ababbabbbababbbabbaba";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        String s = "abc";
        String expOutput = "cbabc";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        String s = "bbc";
        String expOutput = "cbbc";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String s = "ab";
        String expOutput = "bab";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String s = "abcde";
        String expOutput = "edcbabcde";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test6_2() {
        String s = "abcdef";
        String expOutput = "fedcbabcdef";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test6_2: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s = "abcd";
        String expOutput = "dcbabcd";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "a";
        String expOutput = "a";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "";
        String expOutput = "";
        SolutionRabinKarp sol = new SolutionRabinKarp();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}