package leetcode.a2000;

/**
 * 找出前缀异或的原始数组
 * {easy},{bit manipulation},{xor}
 */
public class _2433Solution {
  
    /**
     * 异或的反向运算还是异或
     * @param pref
     * @return
     */
    public int[] findArray(int[] pref) {

        int res[] = new int[pref.length];

        res[0] = pref[0];
        int sum = res[0];
        for(int i=1;i<res.length;i++){

            res[i] = pref[i]^sum;
            sum = sum^res[i];
        }

        return res;
    }
}
