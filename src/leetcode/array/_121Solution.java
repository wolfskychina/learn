package leetcode.array;

public class _121Solution {


    public int maxProfit(int[] prices) {

        int max = 0;
        int left =0;
        int right = 1;
        int length = 0;
        if(prices.length ==0 ||prices.length ==1) return 0;

        while(right<prices.length){

            if(prices[left]<prices[right]){
                //一直处于正收益的情况，收益有可能波动，但是肯定都是正值
                length =prices[right]-prices[left];
                if(length>max) max = length;
                right ++;
            }else{ //如果这样说明这一段的收益要变成负的了，
                // 产生了新低，需要重新选择left的坐标进行计算，可能会出现更大的收益。

                left =right;
                right+=1;
                length = 0;
            }
        }

        return max;
    }
}
