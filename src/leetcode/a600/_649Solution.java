package leetcode.a600;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 双方投票，最后谁能赢
 */
public class _649Solution {
   
    /**
     * 模拟每一轮的投票情况，直到最后
     * 比较慢
     * @param args
     */
    public String predictPartyVictory(String senate) {

        char [] sen = senate.toCharArray();
        while(true){

            for(int i=0;i<sen.length;i++){

                if(sen[i] == 'O') continue;
                boolean change = false;
                for(int j=(i+1)%sen.length,k=0;k<sen.length-1;k++,j=(j+1)%sen.length){
                    if(sen[j] == 'O' || sen[j] == sen[i]) continue;
                    change = true;
                    sen[j] = 'O';
                    break;
                }
                if(!change){
                    return sen[i] == 'R'?"Radiant":"Dire";
                }
            }
        }
    }

    /**
     * 使用队列避免重复遍历已经失效的人员
     * 互相抵消，被抵消的就不用重复入队列，两个队列中的总人数在不断减少
     * 直至一个队列完全为空，另一个队列就赢了
     * {queue}
     * 速度更快
     * @param senate
     * @return
     */
    public String predictPartyVictory1(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            // 在前面的优先
            if (radiantIndex < direIndex) {
                // 使用+n避免了循环
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args){
        _649Solution so = new _649Solution();
        so.predictPartyVictory("RDD");
    }
}
