class Solution {
    public String fractionAddition(String ex) {
        int acc_nom = 0;
        int acc_denom = 0;
        int nom = 0;
        int denom = 0;
        boolean is_minus = false;
        boolean is_nom = true;
        for (int i = 0; i <= ex.length(); i++) {
            char ch = i < ex.length() ? ex.charAt(i) : 'a';
            if (ch == '-' || ch == '+' || i == ex.length()) {
                // lcm = least common multiple
                if (nom != 0 && denom != 0) {
                    if (acc_denom == 0) {
                        acc_nom = (is_minus ? -1 : 1) * nom;
                        acc_denom = denom;
                    } else {
                        int gcd = gcd(Math.abs(denom), Math.abs(acc_denom));
                        int lcm = (Math.abs(denom)*Math.abs(acc_denom))/gcd;
                        acc_nom = acc_nom * lcm/acc_denom + (is_minus ? -1 : 1) * nom *lcm/denom;
                        acc_denom = lcm;
                        int gcd2 = gcd(Math.abs(acc_nom), Math.abs(acc_denom));
                        acc_nom /= gcd2;
                        acc_denom /= gcd2;
                    }
                }
                is_minus = ch == '-';
                is_nom = true;
                nom = 0;
                denom = 0;
            } else if (ch == '/') {
                is_nom = false;
            } else {
                if (is_nom) {
                    nom = nom*10 + (ch-'0');
                } else {
                    denom = denom*10 + (ch-'0');
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (acc_nom == 0) {
            sb.insert(sb.length()-i, '0');
        }
        if (acc_nom < 0) {
            sb.append('-');
        }
        acc_nom = Math.abs(acc_nom);
        while (acc_nom != 0) {
            sb.insert(sb.length()-i, (char)('0' + acc_nom%10));
            acc_nom = acc_nom / 10;
            i++;
        }
        sb.append('/');
        i = 0;
        while (acc_denom != 0) {
            sb.insert(sb.length()-i, (char)('0' + acc_denom%10));
            acc_denom = acc_denom / 10;
            i++;
        }
        return sb.toString();
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    public static void main(String[] args) {
        test2();
        test1();
    }
    private static void test2() {
        String input = "-1/2+1/2+1/3";
        String expOutput = "1/3";
        Solution sol = new Solution();
        String output = sol.fractionAddition(input);
        boolean passed = output.equals(expOutput);
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }
    private static void test1() {
        String input = "7/2+2/3-3/4";
        String expOutput = "41/12";
        Solution sol = new Solution();
        String output = sol.fractionAddition(input);
        boolean passed = output.equals(expOutput);
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}