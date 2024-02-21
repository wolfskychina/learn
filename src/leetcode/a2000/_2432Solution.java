package leetcode.a2000;
/**
 * 处理用时最长的任务
 * TODO
 */
public class _2432Solution {
   
    public int hardestWorker(int n, int[][] logs) {
        int res = logs[0][0];
        int max = logs[0][1];
        for(int i=1;i<logs.length;i++){
            if(logs[i][1]-logs[i-1][1]>max){
                max = logs[i][1]-logs[i-1][1];
                res =logs[i][0];
            }else if(logs[i][1]-logs[i-1][1]==max && res>logs[i][0]){
                res = logs[i][0];
            }
        }
        
        return res;
    }
}
