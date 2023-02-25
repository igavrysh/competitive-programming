public class Main {

    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();

        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
    }

    public static void testSolution1() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("abcabcbb");
        boolean passed = result == 3;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("bbbbb");
        boolean passed = result == 1;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring(" ");
        boolean passed = result == 1;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.lengthOfLongestSubstring("abcabcbb");
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.lengthOfLongestSubstring("bbbbb");
        boolean passed = output == 1;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.lengthOfLongestSubstring("pwwkew");
        boolean passed = output == 3;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.lengthOfLongestSubstring("");
        boolean passed = output == 0;
        System.out.println("testSolutionPractice2_4: " + (passed ? "passed" : "failed"));
    }

}
