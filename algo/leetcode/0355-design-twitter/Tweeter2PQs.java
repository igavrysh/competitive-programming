import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter2PQs {
    private static class Tweet {
        public int t;
        public int tweetId;
        public Tweet(int t, int tweetId) {
            this.t = t;
            this.tweetId = tweetId;
        }
    }
    HashMap<Integer, PriorityQueue<Tweet>> userTweets = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> userFollows = new HashMap<>();
    int t = 0;

    public Twitter2PQs() {
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        PriorityQueue<Tweet> tweets = userTweets.getOrDefault(
            userId,
            generateTweetsPQ()
        );
        tweets.offer(new Tweet(t++, tweetId));
        if (tweets.size() == 11) {
            tweets.poll();
        }
        userTweets.put(userId, tweets);
    }
    
    private static PriorityQueue<Tweet> generateTweetsPQ() {
        return new PriorityQueue<>(
            (tweet1, tweet2) -> 
                Integer.compare(tweet1.t, tweet2.t)
        );
    }

    public List<Integer> getNewsFeed(int userId) {
        // U - # of users
        // Ux10, 10, 
        // U * (10 * log(10)), T: O(N)
        // S: O(1)
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Tweet> q = generateTweetsPQ();
        HashSet<Integer> follows = userFollows.get(userId);
        if (follows == null) {
            return output;
        }
        for (int followeeId : follows) {
            PriorityQueue<Tweet> tweets 
                = userTweets.get(followeeId);
            if (tweets == null) {
                continue;
            }
            for (Tweet tweet : tweets) {
                q.offer(tweet);
                if (q.size() == 11) {
                    q.poll();
                }
            }
        }
        while (!q.isEmpty()) {
            output.add(0, q.poll().tweetId);
        }
        return output;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follows = userFollows.getOrDefault(
            followerId,
            new HashSet<>()
        );
        follows.add(followeeId);
        userFollows.put(followerId, follows);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follows = userFollows.get(followerId);
        if (follows == null) {
            return;
        }
        follows.remove(followeeId);
    }
}