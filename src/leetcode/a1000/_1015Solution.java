package leetcode.a1000;

import java.util.HashSet;

/**
 * 可被k整除的最小所有数位全是1的整数
 * {math},{pegenonhole}
 */
public class _1015Solution {
   
    /**
     * 同余定理，只要出现重复的余数
     * 或者在k次循环中没有整除完（说明一定有重复的余数）
     * 就说明不存在合适的情况
     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        var seen = new HashSet<Integer>();
        int x = 1 % k;
        while (x > 0 && seen.add(x))
            x = (x * 10 + 1) % k;
        return x > 0 ? -1 : seen.size() + 1;
    }

    /**
     * 优化，只要不是2或者5的倍数，一定有n能被k整除
     * @param k
     * @return
     */
    public int smallestRepunitDivByK1(int k) {
        var seen = new HashSet<Integer>();
        int x = 1 % k;
        while (x > 0 && seen.add(x))
            x = (x * 10 + 1) % k;
        return x > 0 ? -1 : seen.size() + 1;
    }

}
