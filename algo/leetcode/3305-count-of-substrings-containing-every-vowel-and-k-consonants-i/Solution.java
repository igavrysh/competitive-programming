class Solution {
    private boolean is_vowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int countOfSubstrings(String word, int k) {
        int[] fq = new int[26];
        int cons = 0;
        int res = 0;
        int l = 0;
        for (int r = 0; r < word.length(); r++) {
            char ch = word.charAt(r);
            if (!is_vowel(ch)) {
                cons++;
            }
            fq[ch-'a']++;
            while (cons > k && l < r) {
                char ch_l = word.charAt(l);
                fq[ch_l-'a']--;
                if (!is_vowel(ch_l)) {
                    cons--;
                }
                l++;
            }
            boolean enough_vowels = true;
            for (int i = 0; i < fq.length; i++) {
                if (is_vowel((char)(i+'a')) && fq[i] == 0) {
                    enough_vowels = false;
                    break;
                }
            }
            if (enough_vowels && cons==k) {
                res++;
                char ch_l = word.charAt(l);
                while (fq[ch_l-'a'] > 1 && is_vowel(ch_l)) {
                    fq[ch_l-'a']--;
                    l++;
                    res++;
                    ch_l = word.charAt(l);
                }
            }
        }

        while (l < word.length()-1) {
            char ch_l = word.charAt(l);
            fq[ch_l-'a']--;
            if (!is_vowel(ch_l)) {
                cons--;
            }
            boolean enough_vowels = true;
            for (int i = 0; i < fq.length; i++) {
                if (is_vowel((char)(i+'a')) && fq[i] == 0) {
                    enough_vowels = false;
                    break;
                }
            }
            if (enough_vowels && cons==k) {
                res++;
            }
            if (cons < k) {
                break;
            }
            l++;
        }
        return res;
    }
    public static void main(String[] args) {
        test725();
        test710();
        test699();
    }
    public static void test725() {
        int k = 0;
        String word = "aaeuoiouee";
        int exp_output = 10;
        Solution sol = new Solution();
        int output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test725:"+(passed ? "passed" : "failed"));
    }
    public static void test710() {
        int k = 0;
        String word = "uiuuoae";
        int exp_output = 2;
        Solution sol = new Solution();
        int output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test710:"+(passed ? "passed" : "failed"));
    }
    public static void test699() {
        int k = 0;
        String word = "ieiaoud";
        int exp_output = 2;
        Solution sol = new Solution();
        int output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test699:"+(passed ? "passed" : "failed"));
    }
}