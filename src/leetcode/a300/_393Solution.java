package leetcode.a300;
/**
 * 判断一个整数数组是否是合法的utf-8字符
 */
public class _393Solution {

    /**
     * 
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {

        int idx = 0;
        while (idx < data.length) {

            int num = 0;
            if (((data[idx] & 0b10000000) >> 7) == 0) {
                idx++;
                continue;
            }
            if ((data[idx] & 0b11100000)  == 0b11000000) {
                num = 1;
            } else if ((data[idx] & 0b11110000)  == 0b11100000) {
                num = 2;
            } else if ((data[idx] & 0b11111000)  == 0b11110000) {
                num = 3;
            } else {
                return false;
            }

            if (idx + num >= data.length)
                return false;

            for (int i = 1; i <= num; i++) {
                // TODO >> 优先级别高于 &
                // 位操作运算符几乎最低
                if ((data[idx + i] & 0b11000000 ) >> 6 != 0b10) {
                    return false;
                }
            }
            idx += num + 1;

        }
        return true;

    }

    public static void main(String[] args){

        _393Solution so = new _393Solution();
        int[] data = {230,136,145};
        // 11000101,10000010,1
        so.validUtf8(data);
    }
}
