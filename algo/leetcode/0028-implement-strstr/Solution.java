public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (haystack.length() > i + j
                    && needle.length() > j
                    && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void test1() {
        Solution s = new Solution();
        int output = s.strStr("hello", "ll");
        boolean passed = output == 2;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.strStr("aaaaa", "baa");
        boolean passed = output == -1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        int output = s.strStr("aaaaa", "");
        boolean passed = output == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
