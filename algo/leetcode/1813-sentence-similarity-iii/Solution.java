class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() < s2.length()) {
            return areSentencesSimilar(s2, s1);
        }
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        int s1_left = -1; int s1_right = s1s.length;
        int s2_left = -1; int s2_right = s2s.length;
        while (s1_left+1<s1s.length && s2_left+1<s2s.length && s1s[s1_left+1].equals(s2s[s2_left+1])) {
            s1_left++;
            s2_left++;
        }
        while (s1_right-1>=0 && s2_right-1>=0 && s2_left<s2_right-1 && s1s[s1_right-1].equals(s2s[s2_right-1])) {
            s1_right--;
            s2_right--;
        }
        return s2_left+1 == s2_right;
    }

    public static void main(String[] args) {
        test136();
        test35();
        test1();
        test2();
    }

    public static void test1() {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.areSentencesSimilar(sentence1, sentence2);
        boolean passed = output == exp_output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String sentence1 = "Eating right now";
        String sentence2 = "Eating";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.areSentencesSimilar(sentence1, sentence2);
        boolean passed = output == exp_output;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test35() {
        String sentence1 = "xD iP tqchblXgqvNVdi";
        String sentence2 = "FmtdCzv Gp YZf UYJ xD iP tqchblXgqvNVdi";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.areSentencesSimilar(sentence1, sentence2);
        boolean passed = output == exp_output;
        System.out.println("test35: " + (passed ? "passed" : "failed"));
    }

    public static void test136() {
        String sentence1 = "A A AAa";
        String sentence2 = "A AAa";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.areSentencesSimilar(sentence1, sentence2);
        boolean passed = output == exp_output;
        System.out.println("test136: " + (passed ? "passed" : "failed"));
    }
}
