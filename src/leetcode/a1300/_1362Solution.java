package leetcode.a1300;

/**
 * 最接近的因数
 * {math}
 */
public class _1362Solution {

    public int[] closestDivisors(int num) {

        int[] r1 = find(num + 1);
        int[] r2 = find(num + 2);

        if (Math.abs(r1[0] - r1[1]) < Math.abs(r2[0] - r2[1])) {

            return r1;
        } else
            return r2;
    }

    private int[] find(int num) {
        int res[] = new int[2];
        for (int i = (int) Math.sqrt(num); i >= 0; i--) {
            if (num % i == 0) {

                res[0] = i;
                res[1] = num / i;
                return res;
            }
        }

        return res;
    }
}
