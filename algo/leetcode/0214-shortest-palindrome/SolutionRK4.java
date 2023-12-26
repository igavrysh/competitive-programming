public class SolutionRK4 {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chrs = s.toCharArray();
        int N = chrs.length;
        int maxPolLen = 1;
        int hashL = hashCode(chrs, 0, N-1);
        int hashR = hashCodeRev(chrs, 0, N-1);

        int magicNumber = modInverse(27, mod);

        //int power2 = powerWithMod(27, N-1, mod);

        for (int i = N-1; i > 0; i--) {
            if (hashL == hashR && equal(chrs, 0, i/2, i/2+(i%2==0?1:0), i)) {
                maxPolLen = (i+1);
                break;
            }

            int power = powerWithMod(27, i, mod);

            //power2 = (int)((power2 * (long)magicNumber) % mod); 

            hashL = (hashL - h(chrs[i]) * power);
            while (hashL < 0) {
                hashL += mod;
            }

            //hashL = (int)((hashL * (long)magicNumber) % mod);

            hashR = hashR - h(chrs[i]);
            if (hashR < 0) {
                hashR += mod;
            }
            //hashR = hashR / 27;
            hashR = (int)((hashR * (long)magicNumber) % mod);
            // ! not matching for reducing size of polindrome in case div or minos, hash etc ops
            // are implemented incorrectly
            //int hashLProxy = hashCode(chrs, 0, i-1);
            //int hashRProxy = hashCodeRev(chrs, 0, i-1);
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
        long h = 0;
        for (int i = e; i >= s; i--) {
            char chr = chrs[i];
            int chr_hash = h(chr);
            h = (h * 27 + chr_hash) % mod;
        }
        return (int)h;
    }

    private int hashCodeRev(char[] chrs, int s, int e) {
        long h = 0;
        for (int i = s; i <= e; i++) {
            char chr = chrs[i];
            int chr_hash = h(chr);
            h = (h * 27 + chr_hash) % mod;
        }
        return (int)h;
    }

    static int powerWithMod(int base_, int exponent_, int mod_) {
        long base = base_;
        long exponent = exponent_;
        long mod = mod_;
        // result is initially 1, as any number raised to the power of 0 is 1
        long result = 1;
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
        return (int)result;
    }

    static int modInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;

        if (m == 1) {
            return 0;
        }

        while (a > 1) {
            // q is quotient
            q = a / m;
            t = m;

            // m is remainder now, process same as Euclid's algorithm
            m = a % m;
            a = t;
            t = x0;

            // Update x0 and x1
            x0 = x1 - q * x0;
            x1 = t;
        }

        // Make x1 positive
        if (x1 < 0) {
            x1 += m0;
        }

        return x1;
    }

    public static void main(String[] args) {
        test101();
        test0();
        test1();
        test9();
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        SolutionRK4 sol = new SolutionRK4();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test0() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String expOutput = "zyxwvutsrqponmlkjihgfedcbabcdefghijklmnopqrstuvwxyz";
        //String s = "abcd";
        //String expOutput = "dcbabcd";
        SolutionRK4 sol = new SolutionRK4();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test0: " + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        String s = "ababbbabbaba";
        String expOutput = "ababbabbbababbbabbaba";
        SolutionRK4 sol = new SolutionRK4();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }

    public static void test101() {
        String s         = "eteyvqncxvkoffzxhkdpwnaodvgnmofexuhrotdvzeih";
        String expOutput = "hiezvdtorhuxefomngvdoanwpdkhxzffokvxcnqvyeteyvqncxvkoffzxhkdpwnaodvgnmofexuhrotdvzeih";
        SolutionRK4 sol = new SolutionRK4();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test101: " + (passed ? "passed" : "failed"));
    }

}
