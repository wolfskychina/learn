package leetcode.a600;
/**
 * 数字是否是01交替出现的数字
 * {easy}
 */
public class _693Solution {
   
    public boolean hasAlternatingBits(int n) {

        int offset = 31;
        while(((n>>offset) & 1 )==0){
            offset--;
        }
        // find left most 1
        int bit =1;
        while(offset>=0){

            if((((n>>offset) & 1 )^bit)==1){
                return false;
            }
            bit = bit^1;
            offset--;
        }
        return true;

    }

    /**
     * {math}根据逻辑运算性质
     * 对输入 n 的二进制表示右移一位后，得到的数字再与 n 按位异或得到 a。
     * 当且仅当输入 n 为交替位二进制数时，a 的二进制表示全为 1
     * @param n
     * @return
     */
    public boolean hasAlternatingBits1(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }



    public static void main(String[] args){
        _693Solution so = new _693Solution();
        so.hasAlternatingBits(7);
    }
}
