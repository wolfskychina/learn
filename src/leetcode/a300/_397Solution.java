package leetcode.a300;

import java.util.HashMap;
import java.util.Map;
/**
 * 一个整数n，如果是奇数，则可以进行+-1的操作
 * 如果是偶数，则可以/2
 * 如此反复，问n变成1所需的最小操作次数
 * TODO 
 */
public class _397Solution {

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    /**
     * 容易想到递进的dp关系，但是正向遍历没有足够的空间
     * 需要考虑所有的可能
     * 
     */
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                // 需要考虑所有的可能
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    
    }

    public static void main(String[] args){

        _397Solution so = new _397Solution();
        System.out.println(so.integerReplacement(15));
    }
}
