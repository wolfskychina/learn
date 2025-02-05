package leetcode.a2000;

import java.util.Arrays;

/**
 * 最少拿出多少的魔法豆，能够使得所有最终非空的袋子中的魔法豆数量一致
 * {prefix sum},{reverse thinking}
 */
public class _2171Solution {

    /**
     * 需要减少的数量等于总的数量（前缀和）-剩下的数量
     * 剩下的数量越大，需要减少的数量越小
     * @param beans
     * @return
     */
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long pre = 0;
        for (int i = 1; i < beans.length + 1; i++) {
            pre += beans[i - 1];
        }
        long res = Long.MIN_VALUE;
        for (int i = 0; i < beans.length; i++) {
            if (i > 0 && beans[i] == beans[i - 1])
                continue;
            res = Math.max(res, (long) (beans.length - i) * beans[i]);

        }
        return pre - res;
    }

    /**
     * 因为数据集不大，可以直接使用counting代替排序
     * 速度更快
     * {counting}
     * @param beans
     * @return
     */
    public long minimumRemoval1(int[] beans) {
        int n = beans.length;
        int min = beans[0],max = beans[0];
        long sum = 0;
        for(int b:beans){
            min = Math.min(b,min);
            max = Math.max(b,max);
            sum += b;
        }
        int c[] = new int[max - min + 1];
        for(int b:beans){
            c[b-min]++;
        }

        long maxSave = 0, lc = 0;
        for(int i=0;i<=max - min;i++){
            maxSave = Math.max(maxSave,(min + i)*(n-lc));
            lc += c[i];
        }
        return sum-maxSave;
    }
}
