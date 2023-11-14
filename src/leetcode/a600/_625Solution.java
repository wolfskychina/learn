package leetcode.a600;
/**
 * 各个数字位相乘等于num的最小整数
 * {math}
 */
public class _625Solution {

    public int smallestFactorization(int num) {

        StringBuilder sb = new StringBuilder();

        while (num != 1) {
            boolean found = false;
            // 注意除以1没有意义并且会死循环
            // 所以要从2开始
            for (int i = 9; i > 0; i--) {

                if (num % i == 0) {

                    num /= i;
                    found = true;
                    sb.append(i);
                    break;
                }
            }
            if (found == false)
                return -1;
        }

        sb.reverse();
        if (sb.length() > 9)
            return -1;

        //if (sb.length() == 9 && Integer.parseInt(sb.toString()) <= 0) {
         //   return -1;
        //}

        return Integer.parseInt(sb.toString());

    }
}
