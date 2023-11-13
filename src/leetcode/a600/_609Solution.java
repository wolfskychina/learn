package leetcode.a600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 目录中冗余的文件列表
 */
public class _609Solution {

    /**
     * {hashmap}
     * @param paths
     * @return
     */
    public List<List<String>> findDuplicate(String[] paths) {
        // "root/a 1.txt(abcd) 2.txt(efgh)"
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();

        for (String dir : paths) {

            String[] array = dir.split(" ");
            if (array.length == 1)
                continue;
            for (int i = 1; i < array.length; i++) {
                int l = array[i].indexOf("(");
                int r = array[i].indexOf(")");
                String file = array[0] + "/" + array[i].substring(0, l);
                String name = array[i].substring(l + 1, r);
                List<String> tmpList = map.getOrDefault(name, new LinkedList<String>());
                tmpList.add(file);
                map.put(name,tmpList);
            }
        }

        for (Entry<String, List<String>> en : map.entrySet()) {

            if (en.getValue().size() > 1)
                res.add(en.getValue());

        }

        return res;

    }


    public static void main(String[] args){
        _609Solution so = new _609Solution();
        String[] array = new String[4];
        array[0] = "root/a 1.txt(abcd) 2.txt(efgh)";
        array[1] = "root/c 3.txt(abcd)";
        array[2] = "root/c/d 4.txt(efgh)";
        array[3] = "root 4.txt(efgh)";
        so.findDuplicate(array);
    }
}
