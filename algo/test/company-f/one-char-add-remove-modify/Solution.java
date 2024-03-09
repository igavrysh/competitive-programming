
class Solution {
    public boolean matches(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        return false;
    }

    public boolean _matches(int p_s1, int p_s2, boolean allowModifications, String s1, String s2) {
        while (p_s1 < s1.length() && p_s2 < s2.length()) {
            if (s1.charAt(p_s1) == s2.charAt(p_s2)) {
                p_s1++;
                p_s2++;
            } else {
                if (allowModifications == false) {
                    return false;
                }
                if (s1.length() > s2.length()) {
                    if (_matches(p_s1+1, p_s2, false, s1, s2)) {
                        return true;
                    }
                } else {
                    if (_matches(p_s1, p_s2+1, false, s1, s2)) {
                        return true;
                    }
                }
            }
        }
        return p_s1 == s1.length() && p_s2 == s2.length() && !allowModifications;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        String s1 = "cat";
        String s2 = "cats";
        Solution sol = new Solution();
        boolean expOutput = false;
        boolean output = sol.matches(s1, s2);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s1 = "cat";
        String s2 = "at";
        Solution sol = new Solution();
        boolean expOutput = false;
        boolean output = sol.matches(s1, s2);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s1 = "cat";
        String s2 = "cat";
        Solution sol = new Solution();
        boolean expOutput = false;
        boolean output = sol.matches(s1, s2);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s1 = "cat";
        String s2 = "dog";
        Solution sol = new Solution();
        boolean expOutput = false;
        boolean output = sol.matches(s1, s2);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}