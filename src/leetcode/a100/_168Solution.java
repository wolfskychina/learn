package leetcode.a100;
/**
 * 根据excel列的顺序号生成列标
 */
public class _168Solution {
   
    /**
     * excel里面对列的编码方式不同于常见的进制
     * 比如第1列对应号码为A，第27列为AA
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            // 关键是不存在0对应的字母
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
