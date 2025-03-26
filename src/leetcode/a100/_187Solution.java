package leetcode.a100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 查找重复出现的定长DNA序列
 */
public class _187Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> count = new HashMap<>();
        // 注意i的终止条件
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);

            count.put(sub, count.getOrDefault(sub, 0) + 1);

        }

        List<String> res = new ArrayList<>();
        for (Entry<String, Integer> en : count.entrySet()) {
            if (en.getValue() > 1)
                res.add(en.getKey());
        }

        return res;
    }

    /**
     * 直接使用HashSet，更快
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub))
                list.add(sub);
            set.add(sub);
        }
        return list;
    }

    int N = (int) 1e5 + 10, P = 131313;
    int[] h = new int[N], p = new int[N];

    /**
     * 采用基于前缀和的字符串hash，一次计算就能得到子串的hash值
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1)
                ans.add(s.substring(i - 1, i + 10 - 1));
            map.put(hash, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        _187Solution so = new _187Solution();
        List<String> list = so.findRepeatedDnaSequences("AAAAAAAAAAA");
        for(String str : list){
            System.out.println(str);
        }
    }
}
