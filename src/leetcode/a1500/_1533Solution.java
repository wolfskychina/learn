package leetcode.a1500;

/**
 * 找最大整数的索引
 * 数组里面除了一个最大的数，剩下的数全部相同
 * 只有一个比较两个区间和大小的行数可以用
 */
public class _1533Solution {

    public int getIndex(ArrayReader reader) {
        // 获取数组长度
        int length = reader.length();
        // 左右两边各有length / 2个数 左边[0, length /2 -1], 右边 [length - length / 2, length - 1]
        return help(0, length / 2 - 1, length - length / 2, length - 1, reader);
    }

    private int help(int l, int r, int x, int y, ArrayReader reader) {
        int value = reader.compareSub(l, r, x, y);
        if (value > 0) { // 说明在左边
            if (l == r) { // 说明只有1个 不需要在分割了
                return l;
            }
            int length = r - l + 1; // 将[l, r]继续
            return help(l, l + length / 2 - 1, r - length / 2 + 1, r, reader);
        }
        if (value < 0) { // 说明在右边
            if (x == y) { // 说明只有1个 不需要在分割了
                return x;
            }
            int length = y - x + 1; // 将[x, y]继续
            return help(x, x + length / 2 - 1, y - length / 2 + 1, y, reader);
        }
        // 左右两边相等 即[l,r] [x,y]相等 则取r + 1 也等于x - 1
        return r + 1;
    }

    public interface ArrayReader {

        int compareSub(int x, int y, int a, int b);

        int length();

    }
}
