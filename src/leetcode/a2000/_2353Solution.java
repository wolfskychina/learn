package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.a800.Pair;

/**
 * 设计菜品评分系统
 * 本质上是一种索引，使用了懒删除技术，类似于乐观锁
 * {lazy heap},{priority queue},{design},{index}
 */
public class _2353Solution {

    class FoodRatings {
        // 特定食物的得分信息 foodRatingIdx
        Map<String, Pair<Integer, String>> fs = new HashMap<>();
        // 每个品类的单独排行榜
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

        /**
         * 无脑添加，适合修改多但是访问少的情况
         * @param food
         * @param newRating
         */
        public void changeRating(String food, int newRating) {
            var c = fs.get(food).getValue();
            cs.get(c).offer(new Pair<>(newRating, food)); // 直接添加新数据，后面 highestRated 再删除旧的
            fs.put(food, new Pair<>(newRating, c));
        }

        /**
         * 访问的时候进行确认，旧的数据删除
         * @param cuisine
         * @return
         */
        public String highestRated(String cuisine) {
            var q = cs.get(cuisine);
            // 懒删除堆
            while (!Objects.equals(q.peek().getKey(), fs.get(q.peek().getValue()).getKey())) // 堆顶的食物评分不等于其实际值
                q.poll();
            return q.peek().getValue();
        }
    }
}
