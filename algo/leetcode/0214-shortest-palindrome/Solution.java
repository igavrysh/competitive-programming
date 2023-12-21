import java.util.ArrayList;

class Solution {
    public String shortestPalindrome(String s) {
        int N = s.length();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(s.charAt(i));
        }

        int t = hashCode(list, 0, N-1);

        return "abc";
    }

    private int hashCode(ArrayList<Character> list, int s, int e) {
        int incr = 0;
        if (e >= s) {
            incr = 1;
        } else if (e < s) {
            incr = -1;
        }
        int h = 0;
        for (int i = s; i != e+incr; i += incr) {
            h = h * 26 + ((list.get(i) - 'a') & 0xff);
        }
        return h;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s = "aacecaaa";
        String expOutput = "aaacecaaa";
        Solution sol = new Solution();
        String output = sol.shortestPalindrome(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
