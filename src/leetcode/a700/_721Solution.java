package leetcode.a700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/**
 * 将账户归并，名称相同且拥有相同电子邮件地址的算一个账户
 */
public class _721Solution {

    /**
     * 很慢的并查集
     * {union},{intersect}
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<TreeSet<String>>> map = new HashMap<>();
        for (List<String> acc : accounts) {

            String key = acc.get(0);
            TreeSet<String> set = new TreeSet<>();
            for (int i = 1; i < acc.size(); i++) {
                set.add(acc.get(i));
            }
            List<TreeSet<String>> list = map.getOrDefault(key, new ArrayList<>());
            list.add(set);
            map.put(key, list);

        }

        for (java.util.Map.Entry<String, List<TreeSet<String>>> en : map.entrySet()) {

            List<TreeSet<String>> list = en.getValue();
            List<TreeSet<String>> newlist = new ArrayList<>();
            while (true) {

                for (int i = 0; i < list.size(); i++) {

                    boolean ifjoin = false;
                    for (int j = 0; j < newlist.size(); j++) {

                        // 如果和newlist中的有交集，则和newlist中的相关的合并
                        TreeSet<String> join = new TreeSet<>(list.get(i));
                        join.retainAll(newlist.get(j));
                        if (join.size() != 0) {
                            // found a cross
                            newlist.get(j).addAll(list.get(i));
                            ifjoin = true;
                            break;
                        }
                    }
                    if (!ifjoin) {
                        newlist.add(list.get(i));
                    }
                }

                if (list.size() == newlist.size())
                    break;
                else {
                    list = newlist;
                    newlist = new ArrayList<>();
                }

            }

            map.put(en.getKey(), newlist);

        }

        List<List<String>> res = new ArrayList<>();
        for (java.util.Map.Entry<String, List<TreeSet<String>>> en : map.entrySet()) {

            for (TreeSet<String> set : en.getValue()) {
                List<String> list = new ArrayList<>();
                list.add(en.getKey());
                for (String str : set) {
                    list.add(str);
                }
                res.add(list);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        _721Solution so = new _721Solution();

        List<List<String>> list = new ArrayList<>();
        String[] array1 = { "John", "johnsmith@mail.com", "john_newyork@mail.com" };
        String[] array2 = { "John", "johnsmith@mail.com", "john00@mail.com" };
        list.add(new ArrayList<>(Arrays.asList(array1)));
        list.add(new ArrayList<>(Arrays.asList(array2)));

        so.accountsMerge(list);
    }

}
