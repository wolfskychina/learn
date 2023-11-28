package leetcode.a700;

import java.util.ArrayList;
import java.util.List;
/**
 * 返回left到right之间的自除数
 * 自除是指能整除自己所有位的数，且数位中不能有0
 * {easy}
 */
public class _728Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; i++) {

            if (dealwith(i)) {
                res.add(i);
            }

        }

        return res;

    }

    private boolean dealwith(int i) {

        int ori = i;
        while (i != 0) {
            if(i % 10 == 0 || ori%(i%10)!=0) return false;
            i /= 10;
        }
        return true;
    }
}
