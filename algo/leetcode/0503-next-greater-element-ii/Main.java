import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testSolutionBruteForce1();
        testSolutionBruteForce2();
        testSolutionBruteForce3();

        testSolutionMonoStack1();
        testSolutionMonoStack2();
        testSolutionMonoStack3();
        testSolutionMonoStack4();
        testSolutionMonoStack5();
    }

    public static void testSolutionBruteForce1() {
        int[] nums = new int[] { 1, 2, 1 };
        SolutionBruteForce s = new SolutionBruteForce();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { 2, -1, 2 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionBruteForce1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce2() {
        int[] nums = new int[] { 1, 2, 3, 4, 3 };
        SolutionBruteForce s = new SolutionBruteForce();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { 2, 3, 4, -1, 4 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionBruteForce2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce3() {
        int[] nums = new int[] { 5, 4, 3, 2, 1 };
        SolutionBruteForce s = new SolutionBruteForce();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { -1, 5, 5, 5, 5 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionBruteForce2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonoStack1() {
        int[] nums = new int[] { 1, 2, 1 };
        SolutionMonoStack s = new SolutionMonoStack();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { 2, -1, 2 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionMonoStack1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonoStack2() {
        int[] nums = new int[] { 1, 2, 3, 4, 3 };
        SolutionMonoStack s = new SolutionMonoStack();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { 2, 3, 4, -1, 4 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionMonoStack2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonoStack3() {
        int[] nums = new int[] { 5, 4, 3, 2, 1 };
        SolutionMonoStack s = new SolutionMonoStack();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { -1, 5, 5, 5, 5 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionMonoStack3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonoStack4() {
        int[] nums = new int[] { 1, 2, 1, 2 };
        SolutionMonoStack s = new SolutionMonoStack();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { 2, -1, 2, -1};
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionMonoStack4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMonoStack5() {
        int[] nums = new int[] { 1 };
        SolutionMonoStack s = new SolutionMonoStack();
        int[] output = s.nextGreaterElements(nums);
        int[] expectedOutput = new int[] { -1 };
        boolean passed = Arrays.equals(output, expectedOutput);
        System.out.println("testSolutionMonoStack5: " + (passed ? "passed" : "failed"));
    }
}
