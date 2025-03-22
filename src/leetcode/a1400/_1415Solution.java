package leetcode.a1400;

/**
 * 长度为n的开心字符串中字典序第k小的字符串
 * {backtrace},{dfs}
 */
public class _1415Solution {

    int idx = 0;
    String res = "";

    public String getHappyString(int n, int k) {
        char[] arr = new char[n];
        arr[0] = 'a';
        dfs(arr, 0, n - 1, k);
        arr[0] = 'b';
        dfs(arr, 0, n - 1, k);
        arr[0] = 'c';
        dfs(arr, 0, n - 1, k);
        return res;
    }

    private void dfs(char[] arr, int lastidx, int remain, int k) {
        if (idx == k)
            return;
        if (remain == 0) {
            idx++;
            if (idx == k)
                res = new String(arr);
            return;
        }
        for (int i = 0; i < 3; i++) {
            char next = (char) ('a' + i);
            if (arr[lastidx] == next)
                continue;
            arr[lastidx + 1] = next;
            dfs(arr, lastidx + 1, remain - 1, k);
        }
    }
}
