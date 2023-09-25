package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _355Solution {
    Twitter t = new Twitter();

    class Twitter {
        int tweetseq;
        List<Tweet> tq;
        Map<Integer, Set<Integer>> follow;

        class Tweet {
            int userId;
            int tweetId;

            public Tweet(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
            }
        }

        public Twitter() {
            tweetseq = 1;
            tq = new ArrayList<>();
            follow = new HashMap<>();
            for (int i = 1; i <= 500; i++) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                follow.put(i, set);
            }

        }

        public void postTweet(int userId, int tweetId) {

            tq.add(new Tweet(userId, tweetId));

        }

        public List<Integer> getNewsFeed(int userId) {

            Set<Integer> set = follow.get(userId);
            if (set == null)
                return new ArrayList<Integer>();
            List<Integer> res = new ArrayList<>();
            int k = 0;
            int p = tq.size() - 1;
            while (k != 10 && p >= 0) {

                Tweet t = tq.get(p);
                if (set.contains(t.userId)) {
                    k++;
                    res.add(t.tweetId);
                }
                p--;
            }

            return res;

        }

        public void follow(int followeeId, int followerId) {

            follow.get(followeeId).add(followerId);

        }

        public void unfollow(int followeeId, int followerId) {

            follow.get(followeeId).remove(followerId);

        }
    }

    public static void main(String[] args) {
        _355Solution so = new _355Solution();
        so.t.postTweet(1, 5);
        so.t.getNewsFeed(1);
        so.t.follow(1, 2);
        so.t.postTweet(2, 6);
        so.t.getNewsFeed(1);
        so.t.unfollow(1, 2);
        so.t.getNewsFeed(1);

    }

}
