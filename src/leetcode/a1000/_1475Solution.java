package leetcode.a1000;
/**
 * 商品折扣后的最终价格
 * {monotonic stack}
 */
public class _1475Solution {
   
    public int[] finalPrices(int[] prices) {
        int [] idx = new int[prices.length];
        int [] value = new int[prices.length];
        int j=0;
        value[0] = prices[0];
        idx[0] = 0;
        
        for(int i=1;i<prices.length;i++){
               
                while(j>=0 && prices[i]<=value[j]){
                    prices[idx[j]] -= prices[i];
                    j--;
                }
            
            value[++j] = prices[i];
            idx[j] = i;
                
        }
        return prices;

    }

    public static void main(String[] args){
        _1475Solution so = new _1475Solution();
        int[] prices = {10,1,1,6};
        so.finalPrices(prices);
    }
}
