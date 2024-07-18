package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个数是否是易混淆数
 */
public class _1056Solution {

    /**
     * 需要反转过之后跟原来的数对比，如果恰好对称的话就不算
     * 只校验单个数字位不行。
     * 
     * @param n
     * @return
     */
    public boolean confusingNumber(int n) {

        Set<Integer> not = new HashSet<>();
        not.add(2);
        not.add(3);
        not.add(4);
        not.add(5);
        not.add(7);
        int reverse = 0;
        int ori = n;
        while (n != 0) {
            int i = n % 10;
            if (not.contains(i))
                return false;
            reverse = reverse * 10 + reverse(i);
            n /= 10;
        }
        return ori != reverse;
    }

    private int reverse(int i) {
        switch (i) {
            case 6:
                return 9;
            case 9:
                return 6;
            default:
                return i;

        }
    }
}
