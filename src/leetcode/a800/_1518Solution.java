package leetcode.a800;
/**
 * 再来一瓶问题
 * 注意每一轮无法兑换的空瓶，攒到后来也许可以兑换
 */
public class _1518Solution {
   
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=0;
        int empty = 0;
        while(numBottles>0){
            count+=numBottles;
            empty += numBottles;
            numBottles = empty/numExchange;
            empty = empty%numExchange;

        }
        return count;
    }
}
