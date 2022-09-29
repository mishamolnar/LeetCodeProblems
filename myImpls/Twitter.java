package LeetCode.myImpls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    private int time;
    private Map<Integer, Tweet> tweets;
    private Map<Integer, Set<Integer>> userToAuthors;

    private class Tweet{
        int time;
        int tweetId;
        Tweet next;

        Tweet(int time, int tweetId, Tweet next) {
            this.time = time;
            this.tweetId = tweetId;
            this.next = next;
        }
    }

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        userToAuthors = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.put(userId, new Tweet(time, tweetId, tweets.get(userId)));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!userToAuthors.containsKey(userId)) {
            userToAuthors.put(userId, new HashSet<>());
            userToAuthors.get(userId).add(userId);
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (Integer integer : userToAuthors.getOrDefault(userId, Collections.emptySet())) {
            if (tweets.containsKey(integer))
                pq.add(tweets.get(integer));
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet curr = pq.poll();
            res.add(curr.tweetId);
            if (curr.next != null)
                pq.add(curr.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userToAuthors.containsKey(followerId)) {
            userToAuthors.put(followerId, new HashSet<>());
            userToAuthors.get(followerId).add(followerId);
        }
        userToAuthors.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userToAuthors.containsKey(followerId)) {
            userToAuthors.put(followerId, new HashSet<>());
            userToAuthors.get(followerId).add(followerId);
        }
        userToAuthors.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
