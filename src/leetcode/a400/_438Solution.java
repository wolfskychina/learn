package leetcode.a400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _438Solution {

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
        while (l < s.length() - len + 1) {

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

            if (!set.contains(s.charAt(ll))) {
                l = ll;
            } else {

                while (set.contains(s.charAt(ll)) && ll < s.length()) {
                    check[s.charAt(l)]++;
                    check[s.charAt(ll)]--;

                    ifValid = true;
                    for (int i = 0; i < 26; i++) {
                        if (check[i] != 0) {
                            ifValid = false;
                            break;
                        }
                    }
                    if (ifValid) {
                        list.add(ll - len);
                    }
                    l++;
                    ll++;
                }

            }

        }

        return list;

    }
}
