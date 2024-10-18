package leetcode.a1100;

/**
 * 从纸牌的前后一共抽取k张牌，能够获取到的最大分数
 * {prefix sum},{sliding window}
 */
public class _1423Solution {

    public int maxScore(int[] cardPoints, int k) {

        int prefix[] = new int[k + 1];
        int postfix[] = new int[k + 1];

        for (int i = 1; i <= k; i++) {

            prefix[i] = prefix[i - 1] + cardPoints[i - 1];
            postfix[i] = postfix[i - 1] + cardPoints[cardPoints.length - i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            max = Math.max(max, prefix[i] + postfix[k - i]);
        }
        return max;
    }

    public static void main(String[] args) {
        _1423Solution so = new _1423Solution();
        int[] points = { 1, 2, 3, 4, 5, 6, 1 };
        so.maxScore(points, 3);
    }
}
