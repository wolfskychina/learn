package leetcode.a700;
/**
 * 从坐标0开始，每次可以向左右两个方向移动，每次移动步数为1,2,3...
 * 依次递增，问最少多少步，才能到达target处
 */
public class _754Solution {

    /**
     * 一直向右，当第一次越过target时进行，分类讨论，如果
     * 距离target的距离为偶数，那么对前面的某个移动改变方向即可
     * 如果距离为奇数，那么需要分类讨论，再多走一步可能距离为偶数或者奇数
     * 如果距离为偶数，那么停止，如果距离为奇数，需要再走一部，能够保证距离为偶数
     * {TODO}
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0, n = 0;
        while (s < target || (s - target) % 2 == 1) // 没有到达（越过）终点，或者相距奇数
            s += ++n;
        return n;
    }

    public static void main(String[] args){

        _754Solution so = new _754Solution();
        so.reachNumber(4);
    }
}
