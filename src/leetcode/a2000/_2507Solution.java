package leetcode.a2000;

public class _2507Solution {

    public int smallestValue(int n) {

        while (true) {
            int sum = 0;
            int tmp = n;
            for (int i = 2; i * i <= tmp; i++)

                while (tmp % i == 0) {
                    tmp /= i;
                    sum += i;
                }
            if (tmp > 1)
                sum += tmp;
            if (sum == n)
                return sum;
            else
                n = sum;
        }

    }

    public static void main(String[] args) {

        _2507Solution so = new _2507Solution();
        so.smallestValue(4);
    }
}
