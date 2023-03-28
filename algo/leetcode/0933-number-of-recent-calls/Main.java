public class Main {
    public static void main(String[] args) {
        testRecentCounter1();
    }

    public static void testRecentCounter1() {
        RecentCounter recentCounter = new RecentCounter();
        boolean passed = true;
        passed = passed && recentCounter.ping(1) == 1;     // requests = [1], range is [-2999,1], return 1
        passed = passed && recentCounter.ping(100) == 2;   // requests = [1, 100], range is [-2900,100], return 2
        passed = passed && recentCounter.ping(3001) == 3;  // requests = [1, 100, 3001], range is [1,3001], return 3
        passed = passed && recentCounter.ping(3002) == 3;  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println("testRecentCounter1: " + (passed ? "passed" : "failed"));
    }
}
