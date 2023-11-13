package leetcode.a600;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _616Solution {

    public String addBoldTag(String s, String[] words) {

        List<int[]> seg = new LinkedList<>();

        // 给所有匹配子串标记坐标
        for (String str : words) {
            int len = str.length();
            int l = -1;
            while (l + 1 < s.length()) {
                int r = s.indexOf(str, l + 1);
                seg.add(new int[] { r, r + len });
                l = r;
            }
        }
        if (seg.size() == 0)
            return s;

        // 合并重复单元格
        Collections.sort(seg, (o1, o2) -> o1[0] == o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        List<int[]> newseg = new LinkedList<>();

        int curL = seg.get(0)[0];
        int curR = seg.get(0)[1];
        for (int i = 1; i < seg.size(); i++) {

            int l = seg.get(i)[0];
            int r = seg.get(i)[1];
            if (l >= curL && r <= curR)
                continue;
            if (l >= curL && l <= r) {
                curR = r;
            } else {
                newseg.add(new int[] { curL, curR });
                curL = l;
                curR = r;
            }
        }
        newseg.add(new int[] { curL, curR });

        // 构造最终字符串
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int[] part : newseg) {
            sb.append(s.substring(last, part[0]));
            sb.append("<b>");
            sb.append(s.substring(part[0], part[1]));
            sb.append("<//b>");
            last = part[1];
        }
        sb.append(s.substring(last, s.length()));

        return sb.toString();
    }

    public static void main(String[] args){
        _616Solution so = new _616Solution();
        String[] a = {"abc","123"};
        so.addBoldTag("abcxyz123",a);
    }
}
