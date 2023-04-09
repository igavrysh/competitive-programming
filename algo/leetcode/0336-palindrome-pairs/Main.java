import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        testSolutionHashMap1();
        testSolutionHashMap2();
        testSolutionHashMap3();
    }

    public static void testSolutionHashMap1() {
        String[] words = new String[]{"abcd", "dcba", "lls", "s" , "sssll" };
        SolutionHashMap s = new SolutionHashMap();
        List<List<Integer>> output = s.palindromePairs(words);
        boolean passed = output.size() == 4 
            && output.contains(Arrays.asList(new Integer[]{ 0, 1 }))
            && output.contains(Arrays.asList(new Integer[]{ 1, 0 }))
            && output.contains(Arrays.asList(new Integer[]{ 3, 2 }))
            && output.contains(Arrays.asList(new Integer[]{ 2, 4 }));
        System.out.println("testSolutionHashMap1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashMap2() {
        String[] words = new String[]{ "bat", "tab", "cat" };
        SolutionHashMap s = new SolutionHashMap();
        List<List<Integer>> output = s.palindromePairs(words);
        boolean passed = output.size() == 2
            && output.contains(Arrays.asList(new Integer[]{ 0, 1 }))
            && output.contains(Arrays.asList(new Integer[]{ 1, 0 }));
        System.out.println("testSolutionHashMap2: " + (passed ? "passed" : "failed"));
    }


    public static void testSolutionHashMap3() {
        String[] words = new String[]{ "a", "" };
        SolutionHashMap s = new SolutionHashMap();
        List<List<Integer>> output = s.palindromePairs(words);
        boolean passed = output.size() == 2
            && output.contains(Arrays.asList(new Integer[]{ 0, 1 }))
            && output.contains(Arrays.asList(new Integer[]{ 1, 0 }));
        System.out.println("testSolutionHashMap3: " + (passed ? "passed" : "failed"));
    }
}