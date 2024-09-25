package leetcode.a2000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 公司的命名方式
 * 从关键词集合中选两个不同的词，交换首字母后组成名字
 * 要求交换首字母后的单词不能在原关键词集合中
 * 总共有多少种方式
 * {combination}
 */
public class _2306Solution {

    /**
     * 将名字按照首字母分组，首先同一组的不能选
     * 不同的组里面，后缀相同的也不能选。其他的都可以选
     * 所以根据集合论，两个任意集合总共有2⋅(∣A∣−∣A∩B∣)⋅(∣B∣−∣A∩B∣)种
     * @param ideas
     * @return
     */
    public long distinctNames(String[] ideas) {
        Set<String>[] groups = new HashSet[26];
        Arrays.setAll(groups, i -> new HashSet<>());
        for (String s : ideas) {
            groups[s.charAt(0) - 'a'].add(s.substring(1)); // 按照首字母分组
        }

        long ans = 0;
        for (int a = 1; a < 26; a++) { // 枚举所有组对
            for (int b = 0; b < a; b++) {
                int m = 0; // 交集的大小
                for (String s : groups[a]) {
                    if (groups[b].contains(s)) {
                        m++;
                    }
                }
                ans += (long) (groups[a].size() - m) * (groups[b].size() - m);
            }
        }
        return ans * 2; // 乘 2 放到最后
    }

}
