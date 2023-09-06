package leetcode.a0;

public class _7Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 防止翻转后的数字溢出
            // 如果rev > Integer.MAX_VALUE/10，那么rev乘以10之后必然会溢出。
            // 如果rev = Integer.MAX_VALUE/10呢？ MAX_VALUE=2147483647，rev需要是214748364，代表的原数字只能是1开头的才可以，如果是2开头的，那么原数字x是溢出的不可能，只能是1开头，如果原数字是1开头，那么rev*10之后追后一位是1，不会溢出。
            if (rev > Integer.MAX_VALUE/10 ) return 0;
            if (rev < Integer.MIN_VALUE/10 ) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args){

        _7Solution so = new _7Solution();
        System.out.println(so.reverse(2147483646));
    }
}
