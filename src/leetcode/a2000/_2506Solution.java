package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;
/**
 * 统计相似字符串对的数目
 * {easy}
 */
public class _2506Solution {

    public int similarPairs(String[] words) {

        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {

            int key = hash(word);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int sum = 0;
        for (int i : map.keySet()) {
            int p = map.get(i);
            sum += p * (p - 1) / 2;
        }
        return sum;
    }

    private int hash(String word) {

        int re = 0;
        for (char c : word.toCharArray()) {

            re = re | (1 << (c - 'a'));
        }
        return re;
    }

    public static void main(String[] args){

        _2506Solution so = new _2506Solution();
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        so.similarPairs(words);
    }
}
