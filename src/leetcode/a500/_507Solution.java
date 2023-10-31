package leetcode.a500;

/**
 * 检查一个数是否是perfect数字
 */
public class _507Solution {

    /**
     * 优化限制条件到sqrt(num)
     * 
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (num / i != i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;

    }

    /**
     * 隐含的数学定理，奇完全数目前没有发现
     * 偶完全数符合定理 2的p-1次方*（2的p次方-1），其中p是素数，（2的p次方-1）也是素数
     * 
     * @param num
     * @return
     */
    public boolean checkPerfectNumber1(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

}
