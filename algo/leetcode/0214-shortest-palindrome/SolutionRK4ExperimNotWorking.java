public class SolutionRK4ExperimNotWorking {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chrs = s.toCharArray();
        int N = chrs.length;
        int maxPolLen = 1;
        int hashL = hashCode(chrs, 0, N-1);
        int hashR = hashCodeRev(chrs, 0, N-1);
        for (int i = N-1; i > 0; i--) {
            if (hashL == hashR && equal(chrs, 0, i/2, i/2+(i%2==0?1:0), i)) {
                maxPolLen = (i+1);
                break;
            }

            int power = powerWithMod(27, i, mod);

            hashL = (hashL - h(chrs[i]) * power);
            //if (hashL < 0) {
            //    hashL += mod;
            //}
            hashL = hashL / 27;

            hashR = hashR - h(chrs[i]);
            //if (hashR < 0) {
            //    hashR += mod;
            //}
            hashR = hashR / 27;

            // ! not matching for reducing size of polindrome
            int hashLProxy = hashCode(chrs, 0, i-1);
            int hashRProxy = hashCodeRev(chrs, 0, i-1);
            int t = 1;
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

    static int powerWithMod(int base, int exponent, int mod) {
        // result is initially 1, as any number raised to the power of 0 is 1
        int result = 1;
        // Update base if it is more than or equal to modulus
        base = base % mod;
        while (exponent > 0) {
            // If exponent is odd, multiply base with result
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            // exponent must be even now
            exponent = exponent >> 1; // exponent divided by 2
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        //test0();
        test1();
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        SolutionRK4ExperimNotWorking sol = new SolutionRK4ExperimNotWorking();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test0() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String expOutput = "zyxwvutsrqponmlkjihgfedcbabcdefghijklmnopqrstuvwxyz";
        //String s = "abcd";
        //String expOutput = "dcbabcd";
        SolutionRK4ExperimNotWorking sol = new SolutionRK4ExperimNotWorking();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test0: " + (passed ? "passed" : "failed"));
    }

}
