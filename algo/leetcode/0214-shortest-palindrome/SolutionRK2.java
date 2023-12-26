public class SolutionRK2 {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int N = s.length();
        int maxPolLen = 1;
        int leftS = 0;
        int leftE = 0;
        int rightS = 1;
        int rightE = 1;

        int hashL = h(s.charAt(leftS));
        int hashR = h(s.charAt(rightS));

        int power = 1;

        for (rightE = 1; rightE < N; rightE++) {
            if (hashL == hashR /*&& equal(s, leftS, leftE, rightS, rightE)*/ ) {
                maxPolLen = (rightE - leftS + 1);
            }

            if (rightE == N-1) {
                continue;
            }

            if (rightE % 2 == 1) {
                power = (power * 27) % mod;
                hashR = (hashR * 27 + h(s.charAt(rightE+1))) % mod;
                hashL = (hashL + h(s.charAt(rightS)) * power)%mod;
                leftE++;
            } else {
                hashR = (hashR - h(s.charAt(rightS)) * power) % mod;
                if (hashR < 0) {
                    hashR += mod;
                }
                hashR = (27 * hashR + h(s.charAt(rightE+1)))%mod;
                rightS++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxPolLen; i++) {
            sb.append(s.charAt(i));
        }

        for (int i = maxPolLen; i < N; i++) {
            sb.insert(0, s.charAt(i));
            sb.insert(sb.length(), s.charAt(i));
        }

        return sb.toString();
    }

    private static int mod = 1299709; //(int)Math.pow(10, 4);

    private int h(Character chr) {
        return ((chr - 'a') + 1);
    }

    private boolean equal(String s, int leftS, int leftE, int rightS, int rightE) {
        for (int i=leftS, j=rightE; i <= leftE; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
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
}
