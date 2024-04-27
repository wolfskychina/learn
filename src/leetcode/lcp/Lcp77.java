package leetcode.lcp;

/**
 * 数组中最多能找出多少个元素，使这些元素排列后相邻
 * 元素之间的差值不超过1
 * {counting}
 */
public class Lcp77 {

    public int runeReserve(int[] runes) {

        int count[] = new int[10001];
        for (int i : runes) {

            count[i]++;
        }

        int l = 0;
        int r = 0;
        int res = 0;
        while (l < count.length && r < count.length) {

            if (count[l] == 0) {
                l++;
                continue;
            }

            r = l + 1;
            int tmp = count[l];
            while (r < count.length && count[r] != 0) {
                tmp += count[r];
                r++;
            }

            res = Math.max(res, tmp);
            l = r;
        }

        return res;
    }
}
