package leetcode.a3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 用"x" and "."字符组成的字符串表示一条路
 * x表示坑，.表示正常路面
 * 使用n+1的预算可以修复连续的n个坑
 * 问在预算一定的情况下最多能够修复多少个坑
 */
public class _3119Solution {

    /**
     * {counting},{greedy}
     * 统计加贪心，但是题目有一个隐含的前提，
     * 长度为n的坑如果预算不够，它的长度更短的子段有可能可以修复
     * @param road
     * @param budget
     * @return
     */
    public int maxPotholes(String road, int budget) {

        int count[] = new int[100002];
        char[] r = road.toCharArray();
        int tmp = 0;
        for (int i = 0; i < r.length; i++) {
            if (r[i] == 'x') {
                tmp++;
            } else {
                count[tmp]++;
                tmp = 0;
            }
        }
        // 此处容易漏掉统计末尾的连续坑
        count[tmp]++;
        int res = 0;
        for (int i = count.length - 1; i > 0; i--) {
            if (budget > 0) {
                if(i==2) 
                   res =0; 
                int times = Math.min(budget / (i + 1), count[i]);
                int remain = -budget / (i + 1) + count[i];
                budget -= times * (i + 1);
                res += times * i;
                // 如果有剩余的长度为i的坑预算不够，按照最大化原则，肯定剩下的能填这个i多长就
                // 填多上
                if (remain > 0 &budget>0) {
                    res += budget - 1;
                    break;
                }
            } else {
                break;
            }
        }
        return res;

    }

    /**
     * 直接排序反而更快，可能跟数据量有关
     * @param road
     * @param budget
     * @return
     */
    public int maxPotholes1(String road, int budget) {
        List<Integer> consecutiveCounts = new ArrayList<Integer>();
        int length = road.length();
        int consecutive = 0;
        for (int i = 0; i < length; i++) {
            if (road.charAt(i) == 'x') {
                consecutive++;
                if (i == length - 1 || road.charAt(i + 1) == '.') {
                    consecutiveCounts.add(consecutive);
                    consecutive = 0;
                }
            }
        }
        consecutiveCounts.sort((a, b) -> b - a);
        int totalFix = 0;
        int size = consecutiveCounts.size();
        for (int i = 0; i < size && budget > 0; i++) {
            int fix = Math.min(consecutiveCounts.get(i), budget - 1);
            totalFix += fix;
            budget -= fix + 1;
        }
        return totalFix;
    }

    public static void main(String[] args){
        _3119Solution so = new _3119Solution();
        so.maxPotholes("x.x", 2);
    }
}
