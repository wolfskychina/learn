package leetcode.a500;
/**
 * 分数的加减运算
 * 
 */
public class _592Solution {

    // {gcd}
    public String fractionAddition(String s) {
        // "-1/2+1/2"
        long[] res = { 0, 0 };
        long[] num = new long[2];
        int idx = 0;
        int r = idx;
        while (idx < s.length()) {
            r = idx;
            while (s.charAt(r) != '/') {
                r++;
            }
            while (r<s.length() &&( s.charAt(r) != '+' && s.charAt(r) != '-'))
                r++;
            String[] tmps = s.substring(idx, r).split("/");
            num[0] = Long.parseLong(tmps[0]);
            num[1] = Long.parseLong(tmps[1]);

            fractionAdd(res, num);
            idx = r;

        }

        if (res[0] == 0)
            return "0/1";

        long n1 = res[0] > 0 ? res[0] : -res[0];
        long n2 = res[1];
        if (n1 < n2) {
            long tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        while (n1 % n2 != 0) {
            long tmp = n1 % n2;
            n1 = n2;
            n2 = tmp;
        }
        res[0] /= n2;
        res[1] /= n2;
        return String.valueOf(res[0]) + "/" + String.valueOf(res[1]);

    }

    private void fractionAdd(long[] res, long[] num) {

        if(res[0] ==0) {
            res[0] =num[0];
            res[1] =num[1];
            return ;
        }
        if(num[0] ==0) return ;

        long tmp = res[1];
        res[1] = res[1] * num[1];
        res[0] = res[0] * num[1] + num[0] * tmp;
        return ;
    }

    public static void main(String[] args){
        _592Solution so = new _592Solution();
        so.fractionAddition("-1/2+1/2+1/3");
    }
}
