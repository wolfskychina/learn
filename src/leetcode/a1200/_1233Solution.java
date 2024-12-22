package leetcode.a1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除子文件夹
 * 给定一些文件夹目录
 * 如果有的目录是另外的目录的子目录，那么就从结果集中删除
 * 
 */
public class _1233Solution {

    /**
     * 先按照长度排序，然后再往Trie树里面插入，如果遇到已经有父目录的情况就不插入
     * 可以插入的就是父目录
     * {Trie}
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {

        List<String> res = new ArrayList<>();

        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        Trie tree = new Trie();
        for (String str : folder) {
            if (tree.add(str)) {
                res.add(str);
            }
        }
        return res;
    }

    class Trie {

        boolean has;
        // 变种Trie树
        Map<String, Trie> next;

        public Trie() {
            this.next = new HashMap<>();
        }

        public Trie(String s) {
            this.next = new HashMap<>();
            next.put(s, new Trie());
        }

        boolean add(String s) {
            Trie r = this;

            for (String ss : s.split("/")) {

                if (r.next.get(ss) == null) {
                    r.next.put(ss, new Trie());
                    r = r.next.get(ss);
                } else {

                    if (r.next.get(ss).has) {
                        return false;
                    } else {
                        r = r.next.get(ss);
                    }
                }

            }
            r.has = true;
            return true;

        }
    }
}
