package leetcode.a700;
/**
 * 每一行将上一行的0变成01,1变成10
 * 求第n行的第k位数是0还是1
 */
public class _779Solution {
   
    /**
     * 找规律
     * {math}
     * 递归
     * 奇数位的值来自上一行的值, 偶数位的值来自上一行的值取反
     * TODO
     */
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int above = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 0) {
            return above == 0 ? 1 : 0;
        }
        return above;
    }

    /**
     * 当作一颗二叉树来处理
     * {binary tree}
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar1(int n, int k) {
        int left = 1, right = 1<<(n-1), mid;
        int cur = 0;
        while (left < right){
            mid = (left+right)>>1;
            if (k > mid){
                cur = cur == 0 ? 1 : 0;
                left = mid + 1;
            }else{
                cur = cur == 0 ? 0 : 1;
                right = mid;
            }
        }
        return cur;
    }
}
