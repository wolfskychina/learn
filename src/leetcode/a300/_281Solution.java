package leetcode.a300;

import java.util.Iterator;
import java.util.List;

/**
 * 两个list，交替的遍历输出list中的内容
 */
public class _281Solution {
    private Iterator<Integer> i, j, tmp;

    public _281Solution(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            tmp = j;
            j = i;
            i = tmp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
