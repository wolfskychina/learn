package leetcode.a2000;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 装满杯子所需要的总时长
 * {easy}
 */
public class _2335Solution {
   
    public int fillCups(int[] amount) {

        Queue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1);

        for(int i=0;i<amount.length;i++){
            if(amount[i]!=0)
            q.offer(amount[i]);
        }
        int count=0;
        while(q.size()!=0){
            count++;
            if(q.size()>1){
                int num1 = q.poll();
                int num2 = q.poll();
                num1--;
                num2--;
                if(num1!=0) q.offer(num1);
                if(num2!=0) q.offer(num2);
            }else{
                int num1 = q.poll();
                num1--;
                if(num1!=0) q.offer(num1);
            }
        }
        return count;

    }

     public int fillCups1(int[] amount) {
        int max=Math.max(amount[0],amount[1]);
        max=Math.max(max,amount[2]);
        int sum=amount[0]+amount[1]+amount[2];
        if(2*max>sum){
            return max;
        }
        return (sum+1)/2;


    }
}
