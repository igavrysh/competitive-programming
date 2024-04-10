import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class TwitterLinkedListPQ {
    static class Node {
        public Node next;
        public Node prev;
        public int t;
        public int tweetId;
        public boolean isSentinel = false;
        public int cnt;
        public Node(boolean isSentinel) {
            this.isSentinel = isSentinel;
        }
        public Node(int tweetId, int t) {
            this.tweetId = tweetId;
            this.t = t;
        }
    }
    private Node head;
    private Node tail;
    private int t;
    private HashMap<Integer, Node[]> userHeadTail = new HashMap<>();
    private HashMap<Integer, HashSet<Integer>> userFollows = new HashMap<>();

    public TwitterLinkedListPQ() {
        head = new Node(true);
        tail = new Node(true);
        head.prev = tail;
        tail.next = head;
    }

    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        Node node = new Node(tweetId, t++);
        Node headPrev = head.prev;
        head.prev = node;
        node.next = head;
        headPrev.next = node;
        node.prev = headPrev;
        Node[] headTail = userHeadTail.get(userId);
        if (headTail == null) {
            headTail = new Node[]{node, node};
            node.cnt = 1;
            userHeadTail.put(userId, headTail);
        } else {
            if (head.cnt == 10) {
                Node prevToUserTail = headTail[1].prev;
                Node nextToUserTail = headTail[1].next;
                nextToUserTail.prev = prevToUserTail;
                prevToUserTail.next = nextToUserTail;
                headTail[1] = nextToUserTail;
                headTail[0].cnt--;
            }
            node.cnt = headTail[0].cnt+1;
            headTail[0] = node;
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Node[]> q = new PriorityQueue<>((Node[] n1, Node[] n2) -> -1 * Integer.compare(n1[0].t, n2[0].t));
        HashSet<Integer> follows = userFollows.get(userId);
        if (follows == null) { return output; }
        for (int f : follows) {
            Node[] headTail = userHeadTail.get(f);
            if (headTail != null) {
                q.offer(headTail);
            }
        }

        while (!q.isEmpty() && output.size() < 10) {
            Node[] headTail = q.poll();
            output.add(headTail[0].tweetId);
            if (headTail[0] != headTail[1]) {
                headTail[0] = headTail[0].prev;
                q.offer(headTail);
            }
        }

        return output;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follows = userFollows.get(followerId);
        if (follows == null) {
            follows = new HashSet<Integer>();
            userFollows.put(followerId, follows);
        }
        follows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follows = userFollows.get(followerId);
        if (follows == null) { return; }
        follows.remove(followeeId);
    }

    public static void main(String[] args) {
        test4();
        test3();
        test1();
        test2();
    }

    private static void test1() {
        boolean passed = true;
        Object[] output = null;
        TwitterLinkedListPQ twitter = new TwitterLinkedListPQ();
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
        TwitterLinkedListPQ twitter = new TwitterLinkedListPQ();
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{});
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        boolean passed = true;
        Object[] output = null;
        TwitterLinkedListPQ twitter = new TwitterLinkedListPQ();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        output = twitter.getNewsFeed(1).stream().toArray();
        passed = passed && Arrays.deepEquals(output, new Integer[]{ 3, 5 });
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        boolean passed = true;
        Object[] output = null;
        TwitterLinkedListPQ twitter = new TwitterLinkedListPQ();
        twitter.postTweet(2, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        output = twitter.getNewsFeed(2).stream().toArray();
        passed = passed && Arrays.deepEquals(
            output,
            new Integer[]{505,94,10,13,5}
        );
        twitter.follow(2, 1);
        output = twitter.getNewsFeed(2).stream().toArray();
        passed = passed && Arrays.deepEquals(
            output,
            new Integer[]{22,333,505,94,2,10,13,101,3,5}
        );
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
