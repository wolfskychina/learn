package leetcode.a600;

import java.util.HashSet;
import java.util.Set;
/**
 * 优美的排列2
 * 选择1-n的一个序列，使得相邻两个元素差值的绝对值的不同种类数量恰好有k个
 */
public class _667Solution {

    /**
     * 如果恰好有k个，那么元素间差值的绝对值依次为k,k-1,k-2...1
     * 可以按照n,n-k,n-k+(k-1),n-k+(k-1)-(k-2)...的顺序构建差值
     * 当所有需要的差值都构建了一遍之后，只需要将剩下的元素按照升序或者降序
     * 放到后面即可
     * 采用升序或者降序，取决于构建差值的最后一个元素和0距离更小还是n距离更小
     * 根据贪心规则，可以确保不会出现超过k的差值
     * {arrange},{math}
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {

        int[] res = new int[n];
        int idx = 0;
        int last = n;
        res[idx++] = n;
        Set<Integer> chosen = new HashSet<>();
        chosen.add(n);

        for (int i = k; i >= 1; i--) {

            last = idx%2==1 ? last - i : last + i;
            res[idx++] = last;
            chosen.add(last);

        }

        int remain = n - idx;
        if(Math.abs(last-1)>Math.abs(last-n)){
            // 从大到小输出
            for (int i = n; remain != 0; i--) {
                if (!chosen.contains(i)) {
                    res[idx++] = i;
                    remain--;
                }
            }
        }else{
            for (int i = 1; remain != 0; i++) {
                if (!chosen.contains(i)) {
                    res[idx++] = i;
                    remain--;
                }
            } 
        }

        return res;

    }

    /**
     * 跟自己的思路大体一致，只不过每次选最大差值
     * 比如1-6,k=2的情况，在6之后，选差值为5的，剩下的按照顺序差值均为1
     * 这样能够保证，在前面的差值选完之后，后面剩下的数都是连续的，差值均为1
     * 不在需要保留set
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray1(int n, int k) {
        int[] ans = new int[n];
        int i = 0;
        //p从小到大 q从大到小
        int p = 1, q = n;
        //构造前k个数组 k-1个不同的整数
        //奇数位从大到小，偶数位从小到大
        for (int j = 0; j < k; j++) {
            if (j % 2 == 0) {
                ans[i++] = p++;
            } else {
                ans[i++] = q--;
            }
        }
        //构造剩下的绝对值为1的序列
        if (k % 2 == 0) {
            //偶数时，降序
            while (i < n) {
                ans[i++] = q--;
            }
        } else {
            //奇数时，升序
            while (i < n) {
                ans[i++] = p++;
            }
        }
        return ans;
    }


    public static void main(String [] args){
        _667Solution so  = new _667Solution();
        so.constructArray(3, 1);
    }
}
