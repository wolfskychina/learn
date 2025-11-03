package leetcode.a3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 删除*号之后字典序最小的字符串
 * {stack}
 */
public class _3170Solution {

    /**
     * 处理输入字符串，删除所有星号(*)并返回字典序最小的剩余字符串
     * @param S 输入字符串，包含小写字母和星号
     * @return 删除星号后字典序最小的字符串
     */
    public String clearStars(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] st = new ArrayList[26];
        Arrays.setAll(st, i -> new ArrayList<>());
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '*') {
                // 非星号字符：将当前字符的索引添加到对应字母的列表中
                // 例如：'a'对应索引0的列表，'b'对应索引1的列表
                st[s[i] - 'a'].add(i);
                continue;
            }
            
            // 星号字符：删除"最优"字符以保证剩余字符串字典序最小
            // 策略：从a到z顺序查找第一个非空列表（优先删除较小字母）
            // 删除该列表中最后一个元素（最近出现的索引，避免影响更早字符的顺序）
            for (List<Integer> p : st) {
                if (!p.isEmpty()) {
                    p.remove(p.size() - 1); // 移除列表末尾的索引（最近出现的位置）
                    break; // 找到并删除后立即退出循环，确保每个*只删除一个字符
                }
            }
        }

        List<Integer> idx = new ArrayList<>();
        for (List<Integer> p : st) {
            idx.addAll(p);
        }
        // 按原字符串中的顺序排序索引（保证字符顺序与原字符串一致）
        Collections.sort(idx);

        StringBuilder t = new StringBuilder(idx.size());
        for (int i : idx) {
            t.append(s[i]);
        }
        return t.toString();
    }

}
