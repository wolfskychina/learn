package leetcode.a1600;

/**
 * 使得字符频次唯一的最少删除次数
 * 每次可以删除一个字符
 * {greedy},{counting}
 */
public class _1647Solution {

    public int minDeletions(String s) {

        int count[] = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(i, max);
        }

        int feq[] = new int[max + 1];
        for (int i : count) {
            feq[i]++;
        }

        int sum = 0;
        for (int i = feq.length - 1; i > 0; i--) {
            if (feq[i] > 1) {
                sum += feq[i] - 1;
                if (i > 0)
                    feq[i - 1] += feq[i] - 1;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        _1647Solution so  = new _1647Solution();
        String s = "aab";
        so.minDeletions(s);
    }
}
