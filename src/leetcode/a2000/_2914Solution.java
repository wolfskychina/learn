package leetcode.a2000;

/**
 * 使二进制字符串能够拆成的全部子串均为偶数且子串内部只含一种字符
 * 所需的最少改动的字符的数量
 * {easy}
 */
public class _2914Solution {

    /**
     * 两个一组比较，如果不同则必须修改一个
     * @param s
     * @return
     */
    public int minChanges(String s) {

        char[] ss = s.toCharArray();
        int res = 0;
        // for(int i=0;i<s.length();i+=2){
        // if(ss[i]!=ss[i+1])
        // res++;
        // }
        for (int i = 0; i < ss.length; i += 2) {
            res += ss[i] ^ ss[i + 1];
        }
        return res;
    }
}
