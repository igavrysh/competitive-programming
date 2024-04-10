import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Twitter {
    private HashMap<Integer, HashSet<Integer>> followers = new HashMap<>();
    private HashMap<Integer, ArrayList<Integer>> tweets = new HashMap<>();
    private HashMap<Integer, PriorityQueue<Integer>> newsFeed = new HashMap<>();
    private HashMap<Integer, Integer> timestamps = new HashMap<>();
    private int time = 0;

    class Tweet {
        private int tweetId, time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {}

    private void addUser(int userId) {
        HashSet<Integer> flwrs = followers.getOrDefault(userId, new HashSet<>() {{ add(userId); }});
        for (Integer flwr : flwrs) {
            PriorityQueue<Integer> pq 
                = newsFeed.getOrDefault(
                    flwr,
                    new PriorityQueue<>((t1, t2) -> timestamps.get(t2) - timestamps.get(t1)
                )
            );
            newsFeed.put(flwr, pq);
        }
        followers.put(userId, flwrs);
        tweets.put(userId, new ArrayList<>());
    } 
    
    public void postTweet(int userId, int tweetId) {
        timestamps.put(tweetId, time++);
        if (followers.get(userId) == null) {
            addUser(userId);
        }

        ArrayList<Integer> a = tweets.get(userId);
        a.add(tweetId);

        HashSet<Integer> flwrs = followers.get(userId);
        for (Integer flwr : flwrs) {
            newsFeed.get(flwr).offer(tweetId);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (followers.get(userId) == null) {
            addUser(userId);
        }

        int counter = 10;
        List<Integer> output = new ArrayList<>();
        Queue<Integer> toAdd = new LinkedList<>();
        PriorityQueue<Integer> nf = newsFeed.get(userId);
        while (counter-- > 0 && !nf.isEmpty()) {
            Integer tweetId = nf.poll();
            output.add(tweetId);
            toAdd.offer(tweetId);
        }

        while (!toAdd.isEmpty()) {
            nf.offer(toAdd.poll());
        }

        return output;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followers.get(followerId) == null) {
            addUser(followerId);
        }

        if (followers.get(followeeId) == null) {
            addUser(followeeId);
        }

        HashSet<Integer> flwrs = followers.get(followeeId);
        if (flwrs.contains(followerId)) {
            return;
        }
        flwrs.add(followerId);

        PriorityQueue<Integer> nf = newsFeed.get(followerId);
        ArrayList<Integer> twts = tweets.get(followeeId);
        if (twts == null) {
            return;
        }
        for (int i = 0; i < twts.size(); i++) {
            nf.offer(twts.get(i));
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        PriorityQueue<Integer> pq = newsFeed.get(followerId);
        ArrayList<Integer> twts = tweets.get(followeeId);
        if (pq == null || twts == null) { return; }
        for (int i = twts.size()-1; i>=0; i--) {
            pq.remove(twts.get(i));
        }
        followers.get(followeeId).remove(followerId);
    }

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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */