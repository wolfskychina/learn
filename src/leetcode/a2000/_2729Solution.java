package leetcode.a2000;

/**
 * 判断一个数是否迷人
 * {easy}
 */
public class _2729Solution {
   
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(n*2).append(n*3);
        long newn = Long.parseLong(sb.toString());
        int count[] = new int[10];
        while(newn!=0){
            int i=(int)(newn%10);
            if(i==0||count[i]==1) return false;
            count[i]++;
            newn /=10;
        }
        return true;
    }

    /**
     * 不必拼接就可以进行判断
     * @param n
     * @return
     */
    public boolean isFascinating1(int n) {
        if (n >= 333) {
            return false;
        }
        boolean[] visited = new boolean[10];
        for (int i = 1; i <= 3; i++) {
            int num = n * i;
            while (num > 0) {
                int b = num % 10;
                num /= 10;
                if (b == 0 || visited[b]) {
                    return false;
                }
                visited[b] = true;
            }
        }
        return true;
    }
}
