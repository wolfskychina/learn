package leetcode.a100;
/**
 * 计算折线图中所有可能收益的总和
 * {stock}
 */
public class _122Solution {
  
    /**
     * 找所有的上升序列
     * {stock},{greedy},{two pointers}
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int sum =0;
        
        int  i =1;
        // 一种模式匹配
        while(i<prices.length){
            
            while(i<prices.length && prices[i]<=prices[i-1]){
                i++;
                
            }
            
            l = i-1;
                
            while(i<prices.length && prices[i]>=prices[i-1]){
                i++;  
            }
            
            if(l<prices.length && i-1<prices.length){
                sum+= prices[i-1]-prices[l];
            }
             
        }
       
        return sum;
        
    }
}
