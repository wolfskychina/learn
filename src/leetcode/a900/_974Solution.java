package leetcode.a900;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被k整除的子数组数量
 * {prefix sum},{mod operation}
 */
public class _974Solution {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefix = 0;
        // pre1%k=pre2%k
        for (int i = 0; i < nums.length; i++) {

            // 额外加k，使得不存在负值
            // 比如k=5的时候，2和2-5=-3在mod5运算后是相等的
            // 根据数学定义mod5应该是0-4,但是java运算可能会有负数
            // TODO 模运算相等不能简单的换正负号
            prefix = (k + prefix + nums[i] % k) % k;
            res += map.getOrDefault(prefix, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }

    public int subarraysDivByK1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefix = 0;
        // pre1%k=pre2%k
        for (int i = 0; i < nums.length; i++) {

            // 如果不额外加k的话，模加运算可能会出现负值
            prefix = (prefix + nums[i] % k) % k;
            // 累加的时候就要把正负值相反的模运算相等的前缀数量也加上
            res += map.getOrDefault((k + prefix) % k, 0);
            if (prefix != 0)
                res += map.getOrDefault((-k + prefix) % k, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {

        int a = -5 % 5;
        int b = -4 % 5;
        return;
    }

}
