package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 对1-n之间数字进行栈操作，使得最后的栈内元素等于target
 * {easy},{stack}
 */
public class _1441Solution {

    public List<String> buildArray(int[] target, int n) {

        int i = 1;
        int idx = 0;
        List<String> res = new ArrayList<>();
        while (idx != target.length) {
            if (target[idx] == i) {
                idx++;
                i++;
                res.add("Push");
            } else {
                i++;
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;

    }
}
