package leetcode.a400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 查找一个单词s中所有的p变形词
 */
public class _438Solution {

    /**
     * 滑动窗口
     * 写的比较复杂，调式了很多次
     * {sliding window}
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        Set<Character> set = new HashSet<>();
        int[] pattern = new int[26];
        List<Integer> list = new ArrayList<>();
        int len = p.length();
        if (p == null || p.isEmpty() || s.length() < p.length())
            return list;

        for (int i = 0; i < p.length(); i++) {
            set.add(p.charAt(i));
            pattern[p.charAt(i) - 'a']++;
        }

        int l = 0;
        while (l <= s.length() - len) {

            int scount = 0;
            int ll = l;
            while (scount < len && ll < s.length()) {

                if (!set.contains(s.charAt(ll))) {
                    scount = 0;
                } else {
                    scount++;
                }
                ll++;
            }

            if (scount != len)
                break;

            // find a substring with a lenth len and contains all letters
            // ll-1,ll-2,...ll-len
            // check if [ll-len,ll-1] is a valid
            int[] check = Arrays.copyOf(pattern, 26);
            for (int i = 1; i <= len; i++) {
                check[s.charAt(ll - i) - 'a']--;
            }
            boolean ifValid = true;
            for (int i = 0; i < 26; i++) {
                if (check[i] != 0) {
                    ifValid = false;
                    break;
                }
            }
            if (ifValid) {
                list.add(ll - len);
            }

            if (ll < s.length() && !set.contains(s.charAt(ll))) {
                l = ll+1;
            } else {
                l = ll-len;

                while (ll < s.length() && set.contains(s.charAt(ll))) {
                    check[s.charAt(l) - 'a']++;
                    check[s.charAt(ll) - 'a']--;

                    ifValid = true;
                    for (int i = 0; i < 26; i++) {
                        if (check[i] != 0) {
                            ifValid = false;
                            break;
                        }
                    }
                    if (ifValid) {
                        list.add(l +1);
                    }
                    l++;
                    ll++;
                }

                l = ll+1;

            }

        }

        return list;

    }

    /**
     * 答案的更简洁的解法，统一从p.length的长度开始循环
     * 不额外处理遇到非p中字符的情况，代码更简洁
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            // 使用了Arrays.equals()判断两个数组是否相同
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args){

        _438Solution so = new _438Solution();
        so.findAnagrams("beeaaedcbc", "c");
    }

}
