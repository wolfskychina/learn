package leetcode.a1000;

/**
 * 统计数字之和能被60整除的元素对数
 * {easy}
 */
public class _1010Solution {

    /**
     * {counting}
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {

        int count[] = new int[501];
        for(int i:time){
            count[i]++;
        }
        // 注意中间结果可能溢出
        long res=0;
        for(int i=0;i<501;i++){
            for(int j=i;j<501;j++){

                if((i+j)%60==0&&count[i]!=0&&count[j]!=0){
                    if(i==j){
                        res += (long)count[i]*(count[i]-1)/2;
                    }else{
                        res += (long)count[i]*count[j];
                    }
                }
            }
        }

        return (int)res;
    }

    /**
     * 更巧妙的做法，直接保存60的余数的个数
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60_1(int[] time) {
        int[] modulo = new int[60];
        for (int i : time) {
            modulo[i % 60]++;
        }

        long ans = 0L;
        for (int i = 0; i <= 30; i++) {
            if (modulo[i] == 0)
                continue;
            if (i == 0 || i == 30) {
                ans += (long) modulo[i] * (modulo[i] - 1) / 2;
            } else {
                ans += modulo[i] * modulo[60 - i];
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        _1010Solution so = new _1010Solution();
        int[] time = { 30, 20, 150, 100, 40 };
        so.numPairsDivisibleBy60(time);
    }
}
