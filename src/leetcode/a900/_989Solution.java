package leetcode.a900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组形式的整数加法
 * {easy}
 */
public class _989Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> listk = new ArrayList<>();
        while (k != 0) {
            listk.add(k % 10);
            k /= 10;
        }
        Collections.reverse(listk);
        if (listk.size() == 0)
            listk.add(0);

        List<Integer> listn = new ArrayList<>();
        for (int i : num) {
            listn.add(i);
        }
        if (num.length < listk.size()) {
            List<Integer> tmp = listn;
            listn = listk;
            listk = tmp;
        }
        // num.length > listk.size()
        int carry = 0;
        int l = listn.size() - 1;
        int r = listk.size() - 1;
        while (r >= 0) {
            int sum = listn.get(l) + listk.get(r) + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            listn.set(l, sum);
            l--;
            r--;
        }
        if (carry == 1 && listn.size() == listk.size()) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int i : listn) {
                res.add(i);
            }
            return res;
        }
        if (carry == 1) {
            while (l >= 0) {

                if (listn.get(l) + carry == 10) {
                    listn.set(l, 0);
                    l--;

                } else {
                    listn.set(l, listn.get(l) + carry);
                    break;
                }
            }
            if (l == -1 && carry == 1) {
                List<Integer> res = new ArrayList<>();
                res.add(1);
                for (int i : listn) {
                    res.add(i);
                }
                return res;
            }

        } else {
            return listn;
        }

        return listn;

    }

    public static void main(String[] args) {
        _989Solution so = new _989Solution();
        int[] num = { 6 };
        so.addToArrayForm(num, 809);
    }
}
