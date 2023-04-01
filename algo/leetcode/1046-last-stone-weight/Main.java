public class Main {
    public static void main(String[] args) {
        testSolutionInplace1();
        testSolutionInplace2();
        testSolutionInplace3();
    }

    public static void testSolutionInplace1() {
        int[] stones = new int[]{2,7,4,1,8,1};
        SolutionInplace s = new SolutionInplace();
        int output = s.lastStoneWeight(stones);
        boolean passed = output == 1; 
        System.out.println("testSolutionInplace1: " + (passed ? "passed" : "failed")); 
    }

    public static void testSolutionInplace2() {
        int[] stones = new int[]{1};
        SolutionInplace s = new SolutionInplace();
        int output = s.lastStoneWeight(stones);
        boolean passed = output == 1; 
        System.out.println("testSolutionInplace2: " + (passed ? "passed" : "failed")); 
    }

    public static void testSolutionInplace3() {
        int[] stones = new int[]{3,7,2};
        SolutionInplace s = new SolutionInplace();
        int output = s.lastStoneWeight(stones);
        boolean passed = output == 2; 
        System.out.println("testSolutionInplace3: " + (passed ? "passed" : "failed")); 
    }
}
