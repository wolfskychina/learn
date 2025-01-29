package leetcode.a0;
/**
 * 能够跳跃到末尾位置所需要的最少次数
 * {greedy}
 */
public class _45Solution {

    public int jump(int[] A) {

        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            // curEnd标记了当前队列的末尾，广度优先
            if (i == curEnd) {
                // 有点类似于广度优先
                // curEnd代表本次跳跃能够到达最远位置
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {

        _45Solution so = new _45Solution();
        int[] a = { 2, 3, 1, 1, 0 };
        so.jump(a);
    }
}
