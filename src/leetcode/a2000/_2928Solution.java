package leetcode.a2000;
/**
 * 给小朋友分糖果,将n个糖果分给3个小朋友，每个小朋友不超过
 * limit个蛋糕
 * 
 * {combination math}
 */
public class _2928Solution {
   
    public int distributeCandies(int n, int limit) {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1);
    }

    private int c2(int n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }
}
