package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个字符串数组中，恰好都在两边出现过一次的字符串的个数
 */
public class _2085Solution {

    /**
     * on2有点慢了
     * 
     * @param words1
     * @param words2
     * @return
     */
    public int countWords(String[] words1, String[] words2) {
        Set<String> same = new HashSet<>();
        Set<String> dummy = new HashSet<>();

        for (int i = 0; i < words1.length; i++) {

            for (int j = 0; j < words2.length; j++) {

                if (words1[i].equals(words2[j])) {
                    if (same.contains(words1[i])) {
                        dummy.add(words1[i]);
                    } else {
                        same.add(words1[i]);
                    }
                }
            }
        }
        int count = 0;
        for (String str : same) {
            if (!dummy.contains(str))
                count++;
        }

        return count;
    }

    /**
     * on的时间复杂度
     * @param words1
     * @param words2
     * @return
     */
    public int countWords1(String[] words1, String[] words2) {
        // other: 辅助结构,帮助判断哪些元素出现了多次
        HashSet<String> set1 = new HashSet<>(), set2 = new HashSet<>(), other = new HashSet<>();

        // 遍历循环words1
        for (String s : words1) {
            if (other.contains(s))
                continue; // 出现在other的元素是重复的元素
            if (set1.contains(s)) {
                set1.remove(s);
                other.add(s);// 记录一下出现多次的元素
            } else {
                set1.add(s);
            }
        }

        // 此时set1中都是word1中出现一次的元素
        for (String s : words2) {
            // 1.先把不是交集的元素过滤掉
            if (!set1.contains(s))
                continue;

            if (set2.contains(s)) { // s是重复元素,不需要统计了
                set1.remove(s);
                set2.remove(s);
            } else {
                set2.add(s);
            }
        }

        return set2.size();
    }
}
