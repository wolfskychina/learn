package leetcode.a600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 统计字符串出现的频率，然后输出出现频率最高的k个字符串
 */
public class _692Solution {

    class Node {
        String str;
        int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    /**
     * {sorting}
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Node> list = new ArrayList<>();
        for (String str : map.keySet()) {
            list.add(new Node(str, map.get(str)));
        }

        // 注意compareTo的返回,字符顺序是要求小的在前面
        // 和出现次数是相反的
        Collections.sort(list, (o1, o2) -> o1.times == o2.times ? o1.str.compareTo(o2.str) : o2.times - o1.times);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).str);
        }
        return res;

    }
}
