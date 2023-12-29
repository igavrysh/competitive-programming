public class SolutionKMP {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int M = needle.length();
        int N = haystack.length();
        int[] table = new int[M];
        int i = 0;
        for (int j = 1; j < M; j++) {
            if (needle.charAt(i) == needle.charAt(j)) {
                table[j] = (j > 0 ? table[j-1] : 0) + 1;
                i++;
            } else {
                i = i > 0 ? table[i-1] : 0;
            }
        }
        int n = 0;
        for (int h = 0; h < N;) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                if (n == needle.length()-1) {
                    return h-(needle.length()-1);
                }
                n++;
                h++;
            } else {
                if (n != 0) {
                    n = table[n-1];
                } else {
                    h++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test5();
        test4();
        test1();
        test2();
        test3();
    }

    public static void test5() {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        SolutionKMP s = new SolutionKMP();
        int output = s.strStr(haystack, needle);
        boolean passed = output == 4;
        System.out.println("test5:" + (passed ? "passed" : "failed"));     
    }

    public static void test4() {
        String haystack = "mississippi";
        String needle = "issip";
        SolutionKMP s = new SolutionKMP();
        int output = s.strStr(haystack, needle);
        boolean passed = output == 4;
        System.out.println("test4:" + (passed ? "passed" : "failed"));        
    }

    public static void test1() {
        String haystack = "hello";
        String needle = "ll";
        SolutionKMP s = new SolutionKMP();
        int output = s.strStr(haystack, needle);
        boolean passed = output == 2;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        SolutionKMP s = new SolutionKMP();
        int output = s.strStr("aaaaa", "baa");
        boolean passed = output == -1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        SolutionKMP s = new SolutionKMP();
        int output = s.strStr("aaaaa", "");
        boolean passed = output == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }
    
}
