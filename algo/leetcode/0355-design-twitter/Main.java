import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        boolean passed = true;
        Object[] output = null;
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{ 5 });
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{ 6, 5 });
        twitter.unfollow(1, 2);
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed &&  Arrays.deepEquals(output, new Integer[]{ 5 });
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        boolean passed = true;
        Object[] output = null;
        Twitter twitter = new Twitter();
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{});
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        boolean passed = true;
        Object[] output = null;
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{ 3, 5 });
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
