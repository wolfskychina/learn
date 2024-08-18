package leetcode.a2000;

/**
 * 统计[a,b]区间内，自身各数位都不相同的数字的数量
 * {easy}
 */
public class _3032Solution {

    public int numberCount(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isUnique(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isUnique(int n) {
        int d[] = new int[10];
        while (n > 0) {
            int digit = n % 10;
            if (d[digit] != 0) {
                return false;
            } else {
                d[digit]++;
            }
            n /= 10;
        }
        return true;
    }

    public int numberCount2(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i < 10) {
                count++;
            } else if (i < 100 && i % 11 != 0) {
                count++;
            } else if (i < 1000) {
                int a1 = i % 10;
                int a2 = i / 10 % 10;
                int a3 = i / 100;
                if (a1 != a2 && a1 != a3 && a2 != a3) {
                    count++;
                }
            }
        }
        return count;
    }
}
