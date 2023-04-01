public class Main {
    public static void main(String[] args) {
        testSolutionInplace1();
    }

    public static void testSolutionInplace1() {
        int[] stones = new int[]{2,7,4,1,8,1};
        SolutionInplace s = new SolutionInplace();
        int output = s.lastStoneWeight(stones);
        boolean passed = output == 1; 
        System.out.println("testSolutionInplace1: " + (passed ? "passed" : "failed")); 
    }
}
