package leetcode.a2000;
/**
 * 消除操作后的最短字符串的长度
 * {bit count}
 */
public class _2716Solution {
   
    public int minimizedStringLength(String s) {
        int mask = 0;
        for (var c : s.toCharArray())
            mask |= 1 << (c - 'a');
        return Integer.bitCount(mask);
    }
}
