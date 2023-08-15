import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        int[] maxLength = {0};
        BT(0, 0, 0, maxLength, arr);

        return maxLength[0];
    }

    private void BT(int s, int acc, int currLength, int[] maxLength, List<String> arr) {
        if (s>=arr.size()) return;

        BT(s+1, acc, currLength, maxLength, arr);

        int currVal = 0;
        char[] chrs = arr.get(s).toCharArray();
        for (char ch : chrs) {
            int val = (1 << (ch-'a'));
            if ((val & currVal) != 0) {
                return;
            }
            currVal = currVal | (1 << (ch-'a'));
        }
        if ((acc & currVal) == 0) {
            maxLength[0] = Math.max(maxLength[0], currLength+chrs.length);
            BT(s+1, acc | currVal, currLength+chrs.length, maxLength, arr);
        }
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        List<String> arr = Arrays.asList(new String[]{"un","iq","ue"});
        int expected = 4;
        Solution s = new Solution();
        int actual = s.maxLength(arr);
        boolean passed = actual == expected;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        List<String> arr = Arrays.asList(new String[]{"cha","r","act","ers"});
        int expected = 6;
        Solution s = new Solution();
        int actual = s.maxLength(arr);
        boolean passed = actual == expected;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        List<String> arr = Arrays.asList(new String[]{"aa", "bbb"});
        int expected = 0;
        Solution s = new Solution();
        int actual = s.maxLength(arr);
        boolean passed = actual == expected;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
}