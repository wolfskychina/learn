package leetcode.a1300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 获取某个用户距离l的好友观看的视频列表
 * {graph},{bfs},{classic}
 */
public class _1311Solution {

    /**
     * 细节很容易写错 
     * @param watchedVideos
     * @param friends
     * @param id
     * @param level
     * @return
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
            int[][] friends, int id, int level) {

        boolean visited[] = new boolean[friends.length];
        Queue<Integer> q = new ArrayDeque<>();
        int step = 0;
        q.offer(id);
        visited[id] = true;

        while (!q.isEmpty()) {

            int size = q.size();

            if (step == level) {
                break;
            }

            for (int i = 0; i < size; i++) {

                int node = q.poll();
                // visited[node] = true;

                for (int next : friends[node]) {
                    if (!visited[next]) {
                        // 为了防止重复添加，需要在入队之前标记已访问
                        // 否则当存在环的时候，可能导致重复入队
                        visited[next] = true;

                        q.offer(next);
                    }
                }

            }

            step++;
        }

        List<String> res = new ArrayList<>();
        if (step < level)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i : q) {

            for (String mov : watchedVideos.get(i)) {

                map.put(mov, map.getOrDefault(mov, 0) + 1);
            }
        }

        res = new ArrayList<>(map.keySet());

        Collections.sort(res,
                (s1, s2) -> map.get(s2) - map.get(s1) == 0 ? s1.compareTo(s2) : map.get(s1) - map.get(s2));
        return res;

    }

    public static void main(String[] args) {

        _1311Solution so = new _1311Solution();
        List<List<String>> videos = new ArrayList<>();
        List<String> v1 = new ArrayList<>();
        List<String> v2 = new ArrayList<>();
        List<String> v3 = new ArrayList<>();
        List<String> v4 = new ArrayList<>();
        v1.add("A");
        v1.add("B");
        v2.add("C");
        v3.add("B");
        v3.add("C");
        v4.add("D");
        videos.add(v1);
        videos.add(v2);
        videos.add(v3);
        videos.add(v4);
        // {{"A","B"},{"C"},{"B","C"},{"D"}};
        int[][] friends = { { 1, 2 }, { 0, 3 }, { 0, 3 }, { 1, 2 } };
        so.watchedVideosByFriends(videos, friends, 0, 1);
    }
}
