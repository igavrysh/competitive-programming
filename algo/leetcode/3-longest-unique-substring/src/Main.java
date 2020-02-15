public class Main {

    public static Solution solution = new Solution();

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int result = solution.lengthOfLongestSubstring("abcabcbb");
        assert(result == 3);
    }

    public static void test2() {
        int result = solution.lengthOfLongestSubstring("bbbbb");
        assert(result == 1);
    }

    public static void test3() {
        int result = solution.lengthOfLongestSubstring(" ");
        assert(result == 0);
    }
}
