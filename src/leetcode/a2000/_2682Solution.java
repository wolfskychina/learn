package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 找出游戏的输家
 */
public class _2682Solution {
   
    /**
     * 注意坐标是从1开始的，在取模的时候需要特殊处理
     * {mod}
     * @param n
     * @param k
     * @return
     */
    public int[] circularGameLosers(int n, int k) {

        int round =1;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int next = k%n +1;
        while(!set.contains(next)){
            set.add(next);
            round++;
            next = (next-1+round*k)%n+1;
        }
        if(n==set.size()) return new int[0];
        int res[] = new int[n-set.size()];
        for(int i=1, j=0;i<=n;i++){
            if(!set.contains(i)){
                res[j++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args){

        _2682Solution so = new _2682Solution();
        so.circularGameLosers(1, 1);
    }
}
