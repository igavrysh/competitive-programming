
public class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
    }

    public static void testSolution1() {
        String s1 = "ab", s2 = "eidbaooo";
        Solution s = new Solution();
        boolean output = s.checkInclusion(s1, s2);
        boolean passed = output == true;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        String s1 = "ab", s2 = "eidboaoo";
        Solution s = new Solution();
        boolean output = s.checkInclusion(s1, s2);
        boolean passed = output == false;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }
}