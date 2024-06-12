package leetcode.a400;

/**
 * 有buckets瓶毒药，允许最多round轮测试的情况下，最少需要的小猪的数量
 */
public class _458Solution {

    /**
     * 关键点：每只小猪对于每瓶水，都可以选择喝与不喝
     * 每瓶水也可以选择是否给任意一只小猪喝
     * 关键点：如果让轮次尽可能的多，那么需要的小猪越少
     * 关键点：假设允许两轮，那么每只小猪对任意一瓶水，都可以选择：
     * 自始至终不喝，在第一轮喝，在第二轮喝。。同时尽量避免在第一轮和第二轮都喝
     * ，这种情况降低了区分度
     * 关键点：假设有k只小猪，那么要求n轮的情况下，可以产生(n+1)的k次方个不同的编码，这些不同的编码需要对应到
     * 每一瓶水上，才能对水做区分。
     * 在所有不同编码中，每一瓶水的编码都是唯一的，只要出现小猪死亡的情况，根据死亡的小猪的排列
     * 一定可以确定是哪一瓶水有毒？
     * 关键点：问题转换成为，能够满足(n+1)的k次方>=瓶子数的k的最小值就是最少需要的小猪的数量
     * 那么同时，如果假设了小猪数量一定，也可以求出至少需要多少轮，才能找到毒药
     * 
     * 关键点：轮数和几进制有关、小猪的数量和n进制编码的位数有关,编码的数量和瓶子数量有关
     * 
     * 混合编码要比每次给每只猪不同的水
     * 
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int round = minutesToTest / minutesToDie;
        int system = round + 1;
        int i = 0;
        while (Math.pow(system, i) < buckets) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        _458Solution so = new _458Solution();
        so.poorPigs(1000, 15, 60);
    }
}
