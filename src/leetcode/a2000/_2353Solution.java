package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.a800.Pair;

/**
 * 设计菜品评分系统
 * {lazy heap},{priority queue}
 */
public class _2353Solution {

    class FoodRatings {
        Map<String, Pair<Integer, String>> fs = new HashMap<>();
        Map<String, Queue<Pair<Integer, String>>> cs = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (var i = 0; i < foods.length; i++) {
                String f = foods[i], c = cuisines[i];
                var r = ratings[i];
                fs.put(f, new Pair<>(r, c));
                cs.computeIfAbsent(c,
                        k -> new PriorityQueue<>(
                                (a, b) -> !Objects.equals(a.getKey(), b.getKey()) ? b.getKey() - a.getKey()
                                        : a.getValue().compareTo(b.getValue())))
                        .add(new Pair<>(r, f));
            }
        }

        public void changeRating(String food, int newRating) {
            var c = fs.get(food).getValue();
            cs.get(c).offer(new Pair<>(newRating, food)); // 直接添加新数据，后面 highestRated 再删除旧的
            fs.put(food, new Pair<>(newRating, c));
        }

        public String highestRated(String cuisine) {
            var q = cs.get(cuisine);
            // 懒删除堆
            while (!Objects.equals(q.peek().getKey(), fs.get(q.peek().getValue()).getKey())) // 堆顶的食物评分不等于其实际值
                q.poll();
            return q.peek().getValue();
        }
    }
}
