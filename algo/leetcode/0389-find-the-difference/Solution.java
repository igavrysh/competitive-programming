class Solution {
    public char findTheDifference(String s, String t) {
        int[] fq = new int[26];
        for (char ch : s.toCharArray()) {
            fq[ch-'a'] = fq[ch-'a'] + 1;
        }
        for (char ch : t.toCharArray()) {
            int idx = ch-'a';
            int chFq = fq[idx];
            if (chFq == 0) {
                return ch;
            } else {
                fq[idx] = fq[idx] - 1;
            }
        }
        return '?';      
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s = "abcd", t = "abcde";
        char expOutput = 'e';
        Solution sol = new Solution();
        char output = sol.findTheDifference(s, t);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}