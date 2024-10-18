package leetcode.a1200;

import java.util.HashMap;
import java.util.Map;

/**
 * {design},设计一个可以动态变化的积分排行榜
 * 并能返回得分最高的前k名
 */
public class _1244Solution {

    class Leaderboard {

        Node rankHead;

        // map快速定位，Node前后遍历
        Map<Integer, Node> map;

        public Leaderboard() {
            rankHead = new Node(Integer.MAX_VALUE, -1);
            map = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            Node curr = map.get(playerId);
            if (curr == null) {
                curr = new Node(score, playerId);
                map.put(playerId, curr);
            } else {
                curr.score += score;

                Node prev = curr.prev;
                Node next = curr.next;
                prev.next = next;
                if (next != null)
                    next.prev = prev;
            }

            Node temp = rankHead;
            Node prev = null;
            while (temp != null && temp.score >= curr.score) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = curr;
            curr.prev = prev;
            if (temp != null) {
                curr.next = temp;
                temp.prev = curr;
            }
        }

        public int top(int K) {
            Node temp = rankHead.next;
            int sum = 0;
            while (temp != null && K-- > 0) {
                sum += temp.score;
                temp = temp.next;
            }

            return sum;
        }

        public void reset(int playerId) {
            Node player = map.get(playerId);
            Node prev = player.prev;
            Node next = player.next;

            prev.next = next;
            if (next != null)
                next.prev = prev;

            map.put(playerId, null);
        }

        class Node {
            int score;
            int playId;

            Node prev;
            Node next;

            public Node(int score, int playId) {
                this.score = score;
                this.playId = playId;
            }
        }
    }
}
