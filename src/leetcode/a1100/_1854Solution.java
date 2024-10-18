package leetcode.a1100;
/**
 * 拥有最多人口的年份
 * {easy}
 */
public class _1854Solution {
   
    public int maximumPopulation(int[][] logs) {
        int count[] = new int[101];
        for(int [] log:logs){
            
            for(int i=log[0];i<log[1];i++){
                count[i-1950]++;
            }
        }
        int maxYear =0;
        int maxidx = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>maxYear){
                maxYear = count[i];
                maxidx = i;
            }
        }
        return maxidx+1950;
    }

    /**
     * {prefix sum}
     * 使用前缀和做差分，只需要on的时间复杂度
     * @param logs
     * @return
     */
    public int maximumPopulation1(int[][] logs) {
        // 差分
        // 出生年+1，死亡年-1；一轮遍历年份找最大值
        int[] count = new int[101];
        for (int[] lo : logs) {
            count[lo[0] - 1950]++;
            count[lo[1] - 1950]--;
        }
        int pre = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i <= 100; ++i) {
            pre += count[i];
            if (max < pre) {
                max = pre;
                res = i;
            }
        }
        return res + 1950;
    }
}
