package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 找到小镇的法官
 * {easy}
 */
public class _997Solution {

    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;
        int betruestednum[] = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int[] t : trust) {
            betruestednum[t[1]]++;
            set.remove(t[0]);
        }
        if (set.size() == 0)
            return -1;
        int count = 0;
        int res = -1;
        for (int i : set) {
            if (count > 1)
                return -1;
            if (betruestednum[i] == n - 1) {
                count++;
                res = i;
            }
        }
        return res;
    }
}
