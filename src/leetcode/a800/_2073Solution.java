package leetcode.a800;
/**
 * 限购1张票然后重新排队的状态下，第k个人买完所有票需要的时间
 * {easy}
 */
public class _2073Solution {
   
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum =0;

        for(int i=0;i<=k;i++){
            sum += Math.min(tickets[i],tickets[k]);
        }
        for(int i=k+1;i<tickets.length;i++){
            sum += Math.min(tickets[i],tickets[k]-1);
        }
        return sum;
    }
}
