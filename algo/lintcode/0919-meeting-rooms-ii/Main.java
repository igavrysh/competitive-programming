import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       testSolutionPractice2_5(); 
    }

    public static void testSolutionPractice2_5() {
        List<Interval> intervals = new ArrayList<>() {{ add(new Interval(0, 30)); add(new Interval(5, 10)); add(new Interval(15, 20)); }};
        Solution s = new Solution();
        int output = s.minMeetingRooms(intervals);
        boolean passed = output == 2;
        System.out.println("testSolutionPractice2_5: " + (passed ? "passed" : "failed"));
    }
}
